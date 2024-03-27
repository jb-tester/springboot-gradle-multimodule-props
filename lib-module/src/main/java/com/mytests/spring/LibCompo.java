package com.mytests.spring;

import org.springframework.stereotype.Component;

/**
 * *
 * <p>Created by irina on 3/31/2023.</p>
 * <p>Project: springboot-gradle-multimodule-props</p>
 * *
 */
@Component
public class LibCompo {

    private final LibConfigProps libConfigProps;

    public LibCompo(LibConfigProps libConfigProps) {
        this.libConfigProps = libConfigProps;
    }

    public String showProps(){
        return libConfigProps.getProp();
    }
}
