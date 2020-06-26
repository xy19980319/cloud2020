package com.xiaoxiao.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.Date;

/**
 * @author Xiaoyu
 * @date 2020/6/25 - 23:32
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******进入MyGatewayFilter"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");//从请求的查询参数中获取uname属性的值
        //如果没有uname,那么错误逻辑
        if(uname==null) {
            log.info("*******非法用户,请重新登录");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//设置状态码失败
            return exchange.getResponse().setComplete();//将错误返回
        }

        return chain.filter(exchange);//放行
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
