package com.lgd.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 15:50
 */
@Slf4j
@SpringBootApplication
public class SystemRun {

    public static void main(String[] args) {
        SpringApplication.run(SystemRun.class, args);
        log.info("==>【乐观点-系统微服务】启动成功");
    }
}
