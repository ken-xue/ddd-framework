# ddd-framework

<p align="center">
  <a href="https://github.com/ken-xue/ddd-framework/blob/master/LICENSE">
    <img src="https://img.shields.io/static/v1?label=license&message=MIT&color=green">
  </a>
  <a href="https://www.oracle.com/java">
    <img src="https://img.shields.io/static/v1?label=JDK&message=1.8&color=red">
  </a>
</p>
<p align="center">
<a title="GitHub Watchers" target="_blank" href="https://github.com/ken-xue/ddd-framework/watchers"><img alt="GitHub Watchers" src="https://img.shields.io/github/watchers/ken-xue/ddd-framework.svg?label=Watchers&style=social"></a>  
  <a title="GitHub Stars" target="_blank" href="https://github.com/ken-xue/ddd-framework/stargazers"><img alt="GitHub Stars" src="https://img.shields.io/github/stars/ken-xue/ddd-framework.svg?label=Stars&style=social"></a>  
  <a title="GitHub Forks" target="_blank" href="https://github.com/ken-xue/ddd-framework/network/members"><img alt="GitHub Forks" src="https://img.shields.io/github/forks/ken-xue/ddd-framework.svg?label=Forks&style=social"></a>
</p>

<p align="center"> 中文简体  |  <a title="Englist" href="README_en.md"> English</a></p>


## 介绍

> ddd-framework 是一款基于领域驱动设计的开发脚手架，拥有极高的拓展性，能够应对大型复杂系统的架构。采用[前](https://github.com/ken-xue/ddd-framework-vue) [后](https://github.com/ken-xue/ddd-framework) 端分离开发, 提供[代码生成器](https://github.com/ken-xue/ddd-framework-maven-plugin)

## 架构

### 分层架构 

![img](./doc/ddd-layer.png)

### 目录结构

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

## 快速开始

1.直接clone项目使用

```bash
git clone https://github.com/ken-xue/ddd-framework.git
cd ddd-framework
mvn clean install
```

2.通过 maven archetype 创建

```bash
# 1.克隆下载
git clone https://github.com/ken-xue/ddd-framework.git
cd ddd-framework
mvn clean install
# 2.创建原型
mvn archetype:create-from-project
cd target/generated-sources/archetype
mvn clean install
# 3.通过原型创建项目
mvn archetype:generate -DarchetypeCatalog=local
```

- 如果遇到mapstruct问题请在Idea里如下设置

Setting->Build,Execution,Deployment->Compiler->User-local build
```shell
-Djps.track.ap.dependencies=false
```

## 代码生成器

1.创建数据库表

2.导入[插件](https://github.com/ken-xue/ddd-framework-maven-plugin) 请先自行下载本地部署或者私服部署

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

3.执行生成命令

```shell
mvn ddd-framework:generate
```
4.清除最近一次生成的代码文件

```shell
mvn ddd-framework:delete
```

5.生成的文件会在你配置的路径下

## 文档

- [详细设计文档]()

## 许可证

MIT see [LICENSE](./LICENSE).  

welcome!
