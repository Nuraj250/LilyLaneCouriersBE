package com.example.lilylane.couriers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * this class enables Cross-Origin Resource Sharing (CORS) support
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * used to configure CORS settings for the application
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH").allowedOrigins("*")
                .allowedHeaders("*");
    }
}
