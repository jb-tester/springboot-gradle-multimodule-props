package com.mytests.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AppModuleApplication implements CommandLineRunner {

    private final AppConfigProps appConfigProps;
    private final LibConfigProps libConfigProps;
    private final PropertiesUsage propertiesUsage;
    private final ConfigurableEnvironment environment;

    public AppModuleApplication(AppConfigProps appConfigProps, LibConfigProps libConfigProps, PropertiesUsage propertiesUsage, ConfigurableEnvironment environment) {
        this.appConfigProps = appConfigProps;
        this.libConfigProps = libConfigProps;
        this.propertiesUsage = propertiesUsage;
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Active property sources:");
        environment.getPropertySources().forEach(propertySource ->
                System.out.println(propertySource.getName()));

        System.out.println(appConfigProps.getProp());
        System.out.println(appConfigProps.getProp2());
        System.out.println(libConfigProps.getProp());
        System.out.println(libConfigProps.getProp2());
        propertiesUsage.displayUsedProps();
    }
}
