package com.example.rallyce.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> bookingServiceRoute(){
        return GatewayRouterFunctions.route("booking_service")
                .route(RequestPredicates.path("/api/booking"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> stockServiceRoute(){
        return GatewayRouterFunctions.route("roomstock_service")
                .route(RequestPredicates.path("/api/stock"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }


}
