package com.mytests.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class LibModuleApplicationTests {

    @Autowired LibCompo libCompo;
    @Autowired
    ApplicationContext ctx;
    @Test
    void contextLoads() {
        System.out.println("************************************************");
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("************************************************");
        System.out.println(libCompo.showProps());
        System.out.println("************************************************");
    }

    @Configuration
    @ComponentScan
    @ConfigurationPropertiesScan
    static
    class Config{

    }
}
