#!/bin/bash

# 应用名
APP_NAME=ddd-framework

PROG_NAME=$0
ACTION=$1
ENV=$2
APP_START_TIMEOUT=60    # 等待应用启动的时间
APP_PORT=8088         # 应用端口
REMOTE_DEBUG_PORT=8888         # 开发环境远程DEBUG端口
HEALTH_CHECK_URL=http://127.0.0.1:${APP_PORT}/api/ok  # 应用健康检查URL
HEALTH_CHECK_FILE_DIR=/home/admin/status   # 脚本会在这个目录下生成nginx-status文件
APP_HOME=/home/admin/app/${APP_NAME} # 从package.tgz中解压出来的jar包放到这个目录下
JAR_NAME=${APP_HOME}/${APP_NAME}.jar # jar包的名字
JAVA_OUT=${APP_HOME}/logs/start.log  #应用的启动日志

# 创建出相关目录
mkdir -p ${HEALTH_CHECK_FILE_DIR}
mkdir -p ${APP_HOME}
mkdir -p ${APP_HOME}/logs
usage() {
    echo "Usage: $PROG_NAME {start|stop|restart} [dev|test|prod]"
    exit 2
}

health_check() {
    exptime=0
    echo "checking ${HEALTH_CHECK_URL}"
    while true
        do
            status_code=`/usr/bin/curl -L -o /dev/null --connect-timeout 5 -s -w %{http_code}  ${HEALTH_CHECK_URL}`
            if [ "$?" != "0" ]; then
               echo -n -e "\rapplication not started"
            else
                echo "code is $status_code"
                if [ "$status_code" == "200" ];then
                    break
                fi
            fi
            sleep 1
            ((exptime++))

            echo -e "\rWait app to pass health check: $exptime..."

            if [ $exptime -gt ${APP_START_TIMEOUT} ]; then
                echo 'app start failed'
               exit 1
            fi
        done
    echo "check ${HEALTH_CHECK_URL} success"
}

start_application() {
    echo "starting java process"
    if [ "$ENV" == "dev" ]
    then
      echo "use env dev"
      nohup java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=${REMOTE_DEBUG_PORT} ${JAR_NAME} > ${JAVA_OUT} --spring.profiles.active=dev 2>&1 &
    elif [ "$ENV" == "test" ]
    then
      nohup java -jar ${JAR_NAME} > ${JAVA_OUT} --spring.profiles.active=test 2>&1 &
      echo "use env test"
    elif [ "$ENV" == "prod" ]
    then
      nohup java -jar ${JAR_NAME} > ${JAVA_OUT} --spring.profiles.active=prod 2>&1 &
      echo "use env prod"
    else
      nohup java -jar ${JAR_NAME} > ${JAVA_OUT} 2>&1 &
      echo "use default env dev"
    fi
    echo "started java process"
}

stop_application() {
   checkjavapid=`ps -ef | grep java | grep ${APP_NAME} | grep -v grep |grep -v 'deploy.sh'| awk '{print$2}'`

   if [[ ! $checkjavapid ]];then
      echo -e "\rno java process"
      return
   fi

   echo "stop java process"
   times=60
   for e in $(seq 60)
   do
        sleep 1
        COSTTIME=$(($times - $e ))
        checkjavapid=`ps -ef | grep java | grep ${APP_NAME} | grep -v grep |grep -v 'deploy.sh'| awk '{print$2}'`
        if [[ $checkjavapid ]];then
            kill -9 $checkjavapid
            echo -e  "\r        -- stopping java lasts `expr $COSTTIME` seconds."
        else
            echo -e "\rjava process has exited"
            break;
        fi
   done
   echo ""
}
start() {
    start_application
    health_check
}
stop() {
    stop_application
}
case "$ACTION" in
    start)
        start
    ;;
    stop)
        stop
    ;;
    restart)
        stop
        start
    ;;
    *)
        usage
    ;;
esac