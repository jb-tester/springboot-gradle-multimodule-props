package com.mytests.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppModuleApplicationTests {

    @Autowired AppConfigProps appConfigProps;
    @Autowired LibConfigProps libConfigProps;



    @Autowired
    public AppModuleApplicationTests(LibConfigProps libConfigProps) {
        this.libConfigProps = libConfigProps;
    }

    @Test
    void contextLoads() {
        System.out.println(appConfigProps.getProp());
        System.out.println(libConfigProps.getProp());
    }

}
