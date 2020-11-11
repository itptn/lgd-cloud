package com.lgd.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限过滤器
 *
 * @author YYJ
 * @version 1.0
 * @since 2020/11/11 11:05
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest httpRequest = exchange.getRequest();
        String path = httpRequest.getPath().value();
        String ip = httpRequest.getHeaders().getFirst("x-forwarded-for");
        log.info("[{}]正在访问[{}]", ip, path);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
