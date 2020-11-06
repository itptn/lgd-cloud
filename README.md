# 乐观点-微服务系统

#### 介绍
{乐观点-微服务系统}

#### 软件架构
* 采用微服务、前后端分离的模式
* 后端版本 [lgd-cloud](https://gitee.com/itptn/lgd-cloud.git)
* 前端版本 [lgd-web](https://gitee.com/itptn/lgd-web.git)

框架(组件) | 版本 | 说明
---|---|---
Spring Boot | 2.3.5.RELEASE |
Spring Cloud | Hoxton.SR8 | 微服务架构组件包
Spring Data Redis | 2.3.5.RELEASE | 缓存
MyBatis-Plus | 3.4.0 | MyBatis增强工具

#### 开发日志
- [ ] 实现登录功能
- [ ] 实现权限功能
- 2020-11-04
- [x] 后端空项目框架提交

#### 使用说明

#### 安装教程

1. 环境准备

服务器 | IP | Nacos | Mysql | Redis | 服务 | 网页
---|---|---|---|---|---|---
master | 39.100.145.118 | - | 主 | - | 节点 | 主
node1 | 47.107.64.177 | - | - | - | 节点 | 从
node2 | 118.25.91.115 | 主 | 从 | 主 | 节点 | 从

2. 组件版本
- CentOS 7.6 64位
- jdk-8u151-linux-x64.rpm
- mysql57-community-release-el7-8.noarch.rpm
- redis-6.0.7.tar.gz
- nacos-server-1.3.2.zip