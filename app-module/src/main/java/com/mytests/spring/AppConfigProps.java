package com.mytests.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * *
 * <p>Created by irina on 3/31/2023.</p>
 * <p>Project: springboot-gradle-multimodule-props</p>
 * *
 */
@ConfigurationProperties("my.app")
public class AppConfigProps {
    String prop;
    String prop2;
    String prop3;

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
