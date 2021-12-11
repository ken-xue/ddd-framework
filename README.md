# ddd-framework

<p align="center">
  <a href="https://gitee.com/mikeygitee/ddd-framework/blob/master/LICENSE">
    <img src="https://img.shields.io/static/v1?label=license&message=MIT&color=green">
  </a>
  <a href="https://gitee.com/mikeygitee/ddd-framework/blob/master/LICENSE">
    <img src="https://img.shields.io/static/v1?label=JDK&message=1.8&color=red">
  </a>
</p>



## Introduction

> ddd-framework 是一款基于领域驱动设计的开发脚手架，拥有极高的拓展性，能够应对大型复杂系统的架构。采用前后端分离开发模式([前端地址]()) 提供代码生成器

## Architecture

### Application Layer

![img](https://cdn.nlark.com/yuque/0/2021/png/2630542/1639145697424-168ad4a4-aa29-4d10-b005-399fc26c00f7.png)

### Directory Structure

```
ddd-framework
    ├─core        核心模块
    │  ├─acl            防腐层
    │  ├─adapter        控制层
    │  ├─application    应用层
    │  ├─core-client    核心二方包
    │  ├─domain         领域层
    │  └─infrastructure 基础设施层
    ├─extensions   外部拓展
    │  └─acl-impl       acl实现
    ├─client            二方包
    ├─core              启动类
    ├─dependencies      依赖管理
    └─doc               文档数据
```

## QuickStart

```bash
git clone https://gitee.com/mikeygithub/ddd-framework.git
cd ddd-framework
mvn install
```
## Document

- [Detail Design Document]()

## License
MIT see [LICENSE](./LICENSE).


# TODO

- 适配多种存储类型
- 验证码问题