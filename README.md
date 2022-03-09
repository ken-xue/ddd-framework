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

> ddd-framework 是一款基于领域驱动设计的开发脚手架，拥有极高的拓展性，能够应对大型复杂系统的架构。采用[前](https://github.com/ken-xue/ddd-framework-vue) [后](https://github.com/ken-xue/ddd-framework) 端分离开发, 提供[代码生成器](./extensions/dev-plugins/code-generator)

## Architecture

### Application Layer  

![img](https://cdn.nlark.com/yuque/0/2021/png/2630542/1639145697424-168ad4a4-aa29-4d10-b005-399fc26c00f7.png)

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

2.config generator properties [see](./extensions/dev-plugins/code-generator/src/main/resources/application.properties)

3.cancel code annotation [see](extensions/dev-plugins/code-generator/src/main/java/com/jiaozhen/zhenfu/codegenerator/execute/CodeGenerateExecutor.java)

4.start CodeGenerator

5.perfect ! success generate code in you project path ! enjoy !

## Document

- [Detail Design Document]()

## License

MIT see [LICENSE](./LICENSE).  

welcome!
