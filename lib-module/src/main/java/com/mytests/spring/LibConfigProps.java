package com.mytests.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * *
 * <p>Created by irina on 3/31/2023.</p>
 * <p>Project: springboot-gradle-multimodule-props</p>
 * *
 */
@ConfigurationProperties("my.lib")
public class LibConfigProps {
    String prop;

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
