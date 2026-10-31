package com.example.springioc.config;

import com.example.springioc.Factory.BYDFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.springioc")
@Configuration
public class AppConfig {
    @Bean
    public BYDFactory bydFactory() {
        return new BYDFactory();
    }
}
