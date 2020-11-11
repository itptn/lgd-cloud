package com.lgd.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/10 11:29
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRun {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRun.class, args);
        log.info("==>【乐观点-网关微服务】启动成功");
    }
}