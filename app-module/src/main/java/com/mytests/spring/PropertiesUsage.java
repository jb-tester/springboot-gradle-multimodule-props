package com.mytests.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
class PropertiesUsage {
    // set in this and lib modules src and test application.properties
    // correct navigation and folding
    @Value("${my.app.prop:some_default}")
    String appProp;
    // set only in this module src application.properties
    // correct navigation and folding
    @Value("${my.app.prop2:some_default}")
    String appProp2;
    // set only in lib module src application.yaml.
    // Navigation should work but doesn't; folding is ok
    @Value("${my.app.prop3:some_default}")
    String appProp3;
    // set in this and lib modules src and test application.properties
    // correct navigation and folding
    @Value("${my.lib.prop:some_default}")
    String libProp;
    // set in lib module src application.properties only.
    // The value should not be resolved -
    // the app module application.properties prevents the lib module application.properties from being loaded.
    @Value("${my.lib.prop2:some_default}")
    String libProp2;

    public void displayUsedProps() {
        System.out.println("====== UsedProps =====");
        System.out.println(appProp);
        System.out.println(appProp2);
        System.out.println(libProp);
        System.out.println(libProp2);
        System.out.println("===================");
    }

    ;

}
