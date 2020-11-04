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
Spring Cloud | Hoxton.SR8 |

#### 开发日志
- 2020-11-04
- [x] 空项目框架提交

#### 使用说明

#### 安装教程

1.  环境准备

服务器 | IP | Nacos | Mysql | Redis | 服务 | 网页
---|---|---|---|---|---|---
master | 39.100.145.118 | - | 主 | - | 节点 | 主
node1 | 47.107.64.177 | - | - | - | 节点 | 从
node2 | 118.25.91.115 | 主 | 从 | 主 | 节点 | 从

2.  组件版本
- CentOS 7.6 64位
- jdk-8u151-linux-x64.rpm
- mysql57-community-release-el7-8.noarch.rpm
- redis-6.0.7.tar.gz
- nacos-server-1.3.2.zip

3.  系统安装
```
vi /etc/hostname
master
vi /etc/sysconfig/network
NETWORKING=yes
HOSTNAME=master
 
vi /etc/hosts
39.100.145.118 master
47.107.64.177 node1
118.25.91.115 node2

ssh-keygen
cd ~/.ssh
ssh-copy-id -i ~/.ssh/id_rsa.pub root@master

wget https://repo.huaweicloud.com/java/jdk/8u151-b12/jdk-8u151-linux-x64.rpm
rpm -ivh jdk-8u151-linux-x64.rpm

vi /etc/profile
export JAVA_HOME=/usr/java/jdk1.8.0_151
export PATH=$JAVA_HOME/bin:$PATH
source /etc/profile

时间同步
ssh master date; ssh node1 date; ssh node2 date;
yum -y install ntp ntpdate
systemctl enable ntpd
systemctl start ntpd
```

4.  安装Mysql 一主一从
```
yum update
wget http://dev.mysql.com/get/mysql57-community-release-el7-8.noarch.rpm
yum localinstall -y mysql57-community-release-el7-8.noarch.rpm
yum repolist enabled | grep "mysql.*-community.*"
yum install -y mysql-community-server
systemctl start mysqld
systemctl status mysqld
grep 'temporary password' /var/log/mysqld.log
mysql -uroot -p
set password for 'root'@'localhost'=password('密码');

CREATE USER 'leguandian'@'%' IDENTIFIED BY 'LeGuan@diaN888';
CREATE DATABASE lgd_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE lgd_person DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE lgd_finance DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE lgd_analysis DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE lgd_web DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE DATABASE lgd_nacos DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL PRIVILEGES ON lgd_system.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON lgd_person.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON lgd_finance.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON lgd_analysis.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON lgd_web.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON lgd_nacos.* TO 'leguandian'@'%'  IDENTIFIED BY 'LeGuan@diaN888' WITH GRANT OPTION;

#master
GRANT REPLICATION SLAVE ON *.* to 'leguandian'@'%' identified by 'LeGuan@diaN888'; 
FLUSH PRIVILEGES;

vi /etc/my.cnf #master
character_set_server=utf8 
init_connect='SET NAMES utf8'
server-id=1
innodb_flush_log_at_trx_commit=2
sync_binlog=1
log_bin=master-bin
log_bin_index=master-bin.index
binlog_ignore_db=mysql
binlog_ignore_db=information_schema
binlog_ignore_db=performation_schema
binlog_ignore_db=sys

systemctl restart mysqld
show master status; #把file列和Position列记录下来，一会配置slave要用到

vi /etc/my.cnf #salve
character_set_server=utf8 
init_connect='SET NAMES utf8'
server-id=2
innodb_flush_log_at_trx_commit=2 
sync_binlog=1 
log-bin=slave-bin-2
log_bin_index=slave-bin-2.index
binlog_ignore_db=mysql
binlog_ignore_db=information_schema
binlog_ignore_db=performation_schema
binlog_ignore_db=sys

systemctl restart mysqld
change master to master_host='master',master_user='leguandian' ,master_password='LeGuan@diaN888', master_log_file='master-bin.000001' ,master_log_pos=2034;

show slave status;
```

5.  安装Nacos 一主(一主两从)
```
cd /opt
unzip nacos-server-1.3.2.zip
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
db.url.0=jdbc:mysql://master:3306/lgd_nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=leguandian
db.password=LeGuan@diaN888

cd nacos/bin
sh startup.sh
sh startup.sh -m standalone
```
6.  安装Redis 一主(三主三从)
```
yum install -y gcc gcc-c++ wget vim net-tools nmap lrasz tree make tcl
yum -y install centos-release-scl
yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
scl enable devtoolset-9 bash
echo "source /opt/rh/devtoolset-9/enable" >>/etc/profile

tar -zxf redis-6.0.7.tar.gz
cd redis-6.0.7

make && make install PREFIX=/opt/redis/6378

vi /opt/redis/redis.conf
daemonize yes
port 6378
port 6379
cluster-enabled yes
cluster-config-file nodes_prot.conf
pidfile /var/run/redis_port.pid
dbfilename dump_port.rdb
appendonly yes
appendfilename "appendonly_port.aof"
dir /var/redis/6378
dir /var/redis/6379
bind 39.100.145.118 0.0.0.0
bind 47.107.64.177 0.0.0.0
bind 118.25.91.115 0.0.0.0
protected-mode no

requirepass lEguanDiAn898

%s#6379#6376#gc

mkdir 6378 6379
/opt/redis/6376/bin/redis-server /opt/redis/6376/redis.conf
/opt/redis/6378/bin/redis-server /opt/redis/6378/redis.conf
/opt/redis/6379/bin/redis-server /opt/redis/6379/redis.conf
/opt/redis/6378/bin/redis-cli --cluster create master:6378 master:6379 node1:6379 node1:6378 node2:6379 node2:6378 --cluster-replicas 1

/opt/redis/6378/bin/redis-cli -c -h master -p 6378
cluster nodes
```
