package com.mitrais.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScans(value = {
        @ComponentScan("com.mitrais.springmvc.service"),
        @ComponentScan("com.mitrais.springmvc.security")
})
public class AppConfig {

    @Autowired
    private Environment env;

}
