package com.vigo.securityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 22/10/2022
 **/

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
                        .allowedHeaders("X-User-Token", "Authorization", "Content-Type")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}
