package com.valdemar.demo.handler;

import com.valdemar.demo.model.services.MateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterFunctionConfig {
    @Autowired
    private MateService mateService;

    @Bean
    public RouterFunction<ServerResponse> routes(MateHandler handler){

        return RouterFunctions.route(RequestPredicates.GET("/api/v1/matematicas/suma"),handler::listar)
        .andRoute(RequestPredicates.POST("/api/v1/mate/suma"), handler::sumar);
    }


}
