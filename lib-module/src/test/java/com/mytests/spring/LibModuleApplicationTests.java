package com.mytests.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class LibModuleApplicationTests {

    @Value("${my.lib.prop: some_default}") String prop;
    @Value("${my.lib.prop2:some_default}") String prop2; // should not show value from src

    @Autowired LibCompo libCompo;
    @Autowired
    ApplicationContext ctx;

    @Test
    void contextLoads() {
        System.out.println("************************************************");
        // display the found configuration properties
        for (String name : ctx.getBeanNamesForAnnotation(ConfigurationProperties.class)) {
            System.out.println(name);
        }
        System.out.println("************************************************");
        System.out.println(libCompo.showProps());
        System.out.println("************************************************");
        System.out.println(prop);
        System.out.println(prop2);
        System.out.println("************************************************");
    }

    @Configuration
    @ComponentScan
    @ConfigurationPropertiesScan
    static
    class Config{

    }
}
