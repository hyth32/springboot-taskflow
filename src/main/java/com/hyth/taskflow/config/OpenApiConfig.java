package com.hyth.taskflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI taskFlowApi() {
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                .title("TaskFlow API")
                .version("1.0.0")
                .description("API for managing task flow operations including user management, task management, and more."));
    }
}
