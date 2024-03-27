package com.mytests.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AppModuleApplication implements CommandLineRunner {

    private final AppConfigProps appConfigProps;
    private final LibConfigProps libConfigProps;

    public AppModuleApplication(AppConfigProps appConfigProps, LibConfigProps libConfigProps) {
        this.appConfigProps = appConfigProps;
        this.libConfigProps = libConfigProps;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appConfigProps.getProp());
        System.out.println(libConfigProps.getProp());
    }
}
