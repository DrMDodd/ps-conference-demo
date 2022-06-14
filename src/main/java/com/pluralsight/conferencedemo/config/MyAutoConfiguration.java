package com.pluralsight.conferencedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfiguration {

    @Bean
    public Object myMethod() {
        return new Object();
    }
}
