# 乐观点-微服务系统

#### 介绍
{乐观点-微服务系统}

#### 软件架构
* 采用微服务、前后端分离的模式
* 后端版本 [lgd-cloud](https://gitee.com/itptn/lgd-cloud.git)
* 前端版本 [lgd-web](https://gitee.com/itptn/lgd-web.git)

组件(Jar包) | 版本 | 说明
---|---|---
Spring Boot | 2.3.5.RELEASE | Spring-boot组件包
Spring Cloud | Hoxton.SR8 | 微服务架构组件包
Spring Alibaba Cloud | 2.2.3.RELEASE | 微服务阿里组件包
Spring Data Redis | 2.3.5.RELEASE | Redis缓存
MyBatis-Plus | 3.4.0 | MyBatis增强工具
Druid | 1.2.3 | JDBC组件库
Mysql-connector-java | 8.0.22 | Java MySQL连接
Nacos Discovery | 2.2.3.RELEASE | 服务注册与发现
Spring Cloud Gateway | 2.2.3.RELEASE | API网关
Nacos Config | 2.2.3.RELEASE | 分布式配置管理


#### 开发日志
- 2020-11-11
- [X] 实现认证授权功能
- [X] 实现分布式配置管理
- 2020-11-10
- [X] 添加Nacos网关模块
- [X] 添加服务注册与发现
- [x] 实现代码生成功能
- [X] 实现缓存功能
- 2020-11-04
- [x] 添加常用基础模块
- [x] 后端空项目框架提交

#### 使用说明

#### 安装教程
##### 环境准备
服务器 | IP | Nacos | Mysql | Redis | 服务 | 网页
---|---|---|---|---|---|---
node1 | 47.*.*.177 | - | - | - | 节点 | 从
node2 | 118.*.*.115 | 主 | 从 | 主 | 节点 | 从

微服务 | IP | 端口
---|---|---
s-gateway | node1 | 9000
s-system | node1 | 9010

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
db.url.0=jdbc:mysql://node1:3306/lgd_nacos?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
db.user=lgd
db.password=lgd


cd nacos/bin
sh startup.sh
sh startup.sh -m standalone
```
- 
- 