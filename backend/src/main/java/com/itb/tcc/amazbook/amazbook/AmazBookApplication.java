package com.itb.tcc.amazbook.amazbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@SpringBootApplication
public class AmazBookApplication implements WebMvcConfigurer{
    public static void main(String[] args) {
        SpringApplication.run(AmazBookApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/usuarios/**")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
