package com.lgd.system;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 15:50
 */
@Slf4j
@SpringBootApplication
@ComponentScan({"com.lgd"})
@MapperScan("com.lgd.system.mapper")
public class SystemRun {

    public static void main(String[] args) {
        SpringApplication.run(SystemRun.class, args);
        log.info("==>【乐观点-系统微服务】启动成功");
    }
}
