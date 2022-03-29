# ddd-framework

<p align="center">
  <a href="https://github.com/ken-xue/ddd-framework/blob/master/LICENSE">
    <img src="https://img.shields.io/static/v1?label=license&message=MIT&color=green">
  </a>
  <a href="https://www.oracle.com/java">
    <img src="https://img.shields.io/static/v1?label=JDK&message=1.8&color=red">
  </a>
</p>



## Introduction

> ddd-framework 是一款基于领域驱动设计的开发脚手架，拥有极高的拓展性，能够应对大型复杂系统的架构。采用[前](https://github.com/ken-xue/ddd-framework-vue) [后](https://github.com/ken-xue/ddd-framework) 端分离开发, 提供[代码生成器](https://github.com/ken-xue/ddd-framework-maven-plugin)

## Architecture

### Application Layer  

![img](./doc/ddd-layer.png)

### Directory Structure

```
ddd-framework
    ├─core              核心模块
    │  ├─acl                防腐层
    │  ├─adapter            控制层
    │  ├─application        应用层
    │  ├─core-client        核心二方包
    │  ├─domain             领域层
    │  ├─share-dataobject   全局共享数据对象
    │  └─infrastructure     基础设施层
    ├─extensions        外部拓展
    │  └─acl-impl           acl实现
    ├─client                二方包
    ├─core                  启动类
    ├─dependencies          依赖管理
    └─doc                   文档数据
```

## QuickStart

```bash
git clone https://github.com/ken-xue/ddd-framework.git
cd ddd-framework
mvn install
```

Setting->Build,Execution,Deployment->Compiler->User-local build
```shell
-Djps.track.ap.dependencies=false
```

## CodeGenerator

1.create you database table

2.import maven dependency

```xml
<plugin>
    <groupId>io.ddd.framework</groupId>
    <artifactId>ddd-framework-maven-plugin</artifactId>
    <version>1.0.2-SNAPSHOT</version>
    <configuration>
        <dataSource>
            <driverName>com.mysql.cj.jdbc.Driver</driverName>
            <url>jdbc:mysql://127.0.0.1:3306/ddd_framework</url>
            <username>root</username>
            <password>123456</password>
        </dataSource>
        <config>
            <sourcePath>./</sourcePath>
            <tablePrefixes>sys_,biz_</tablePrefixes>
            <moduleName>sys</moduleName>
            <packageName>io.ddd.framework</packageName>
            <tableNames>sys_user,sys_menu</tableNames>
            <excludeFields>id,uuid,creator,modifier,gmt_create,gmt_modified,deleted</excludeFields>
            <author>麦奇</author>
            <email>biaogejiushibiao@outlook.com</email>
        </config>
    </configuration>
</plugin>
```

3.execute cmd 

```shell
mvn ddd-framework:code
```
4.clean last time code

```shell
mvn ddd-framework:delete
```

5.perfect ! success generate code in you project path ! enjoy ! maven plugin source code [see]()

## Document

- [Detail Design Document]()

## License

MIT see [LICENSE](./LICENSE).  

welcome!
