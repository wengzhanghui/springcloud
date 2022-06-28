package com.atzhahui.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhahui
 * @creat -06-23 19:23
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为route-name的路由规则
     * 当访问地址http://localhost:9527/guonei时会自动转发到地址http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        http://news.baidu.com/guonei
        routes.route("path_route_atzhahui1",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();

        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        http://news.baidu.com/guonei
        routes.route("path_route_atzhahui2",
                        r->r.path("/guoji")
                                .uri("http://news.baidu.com/guoji"))
                .build();

        return routes.build();
    }
}
