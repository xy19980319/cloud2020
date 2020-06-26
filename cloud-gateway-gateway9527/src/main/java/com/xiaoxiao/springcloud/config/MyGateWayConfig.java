package com.xiaoxiao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

/**
 * @author Xiaoyu
 * @date 2020/6/25 - 16:08
 */
@Component
public class MyGateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();//这里相当于就是配置中过的routes
        //第一个参数是id,是独一无二就行,对应就是配置中的id,第二个参数是路由,断言过滤的配置
        routes.route("path_route_xiaoxiao",
                r-> r.path("/guonei")                       //这里是访问的断言,相当于配置的- Path属性
                        .uri("https://news.baidu.com/guonei")).build();      //这是具体要跳转的uri
        //测试军事
        routes.route("path_route_xiaoxiao_junshi",
                r->r.path("/mil")
                        .uri("https://news.baidu.com/mil")).build();
        return routes.build();
    }
}
