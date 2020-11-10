# 乐观点-微服务系统

#### 介绍
{乐观点-微服务系统}

#### 软件架构
* 采用微服务、前后端分离的模式
* 后端版本 [lgd-cloud](https://gitee.com/itptn/lgd-cloud.git)
* 前端版本 [lgd-web](https://gitee.com/itptn/lgd-web.git)

框架(组件) | 版本 | 说明
---|---|---
Spring Cloud | Hoxton.SR8 | 微服务架构组件包
Spring Alibaba Cloud | 2.3.5.RELEASE | 微服务阿里组件包
Spring Boot | 2.3.5.RELEASE |
| | | 服务限流降级
| | | 服务注册与发现
| | | 配置中心
Spring Data Redis | 2.3.5.RELEASE | 缓存
MyBatis-Plus | 3.4.0 | MyBatis增强工具

#### 开发日志
- 2020-11-10
- [X] 添加网关模块
- [x] 实现登录功能
- [X] 实现权限功能
- 2020-11-04
- [x] 后端空项目框架提交

#### 使用说明

#### 安装教程
##### 环境准备
服务器 | IP | Nacos | Mysql | Redis | 服务 | 网页
---|---|---|---|---|---|---
node1 | 47.*.*.177 | - | - | - | 节点 | 从
node2 | 118.*.*.115 | 主 | 从 | 主 | 节点 | 从

##### 组件版本
- CentOS 7.6 64位
- jdk-8u151-linux-x64.rpm
- mysql57-community-release-el7-8.noarch.rpm
- redis-6.0.7.tar.gz
- nacos-server-1.4.0.zip

##### 组件安装

- 安装Nacos 一主(一主两从)
```
cd /opt
unzip nacos-server-1.4.0.zip
cd nacos/conf

vi cluster.conf
# ip:port
master:9000
node1:9000
node2:9000

vi application.properties
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://node1:3306/lgd_nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=lgd
db.password=lgd

cd nacos/bin
sh startup.sh
sh startup.sh -m standalone
```
- 
- 

