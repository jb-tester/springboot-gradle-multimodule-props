package com.mytests.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

// This test uses only the test application.properties.
// the main application.properties should be ignored!
@SpringBootTest
class AppModuleApplicationTests {

    @Autowired AppConfigProps appConfigProps;
    @Autowired LibConfigProps libConfigProps;

    @Value("${my.app.prop:some_default}") // overridden in test application.properties
    String appProp;
    @Value("${my.app.prop2:some_default}") // set in this module src application properties; should NOT be available; but navigation and folding work
    String appProp2;
    @Value("${my.lib.prop:some_default}") // overridden in test application.properties
    String libProp;
    @Value("${my.lib.prop2:some_default}") // set in lib module src application properties; should NOT be available; no navigation, but folding works
    String libProp2;

    @Test
    void testOverriddenPropertyFromThisModule() {
        System.out.println(appConfigProps.getProp());
        assert appConfigProps.getProp().equals(appProp);
    }
    @Test
    void testOverriddenPropertyFromLibModule() {
        System.out.println(libConfigProps.getProp());
        assert libConfigProps.getProp().equals(libProp);
    }
    @Test
    void testSrcPropertyFromThisModule() {
        assert appConfigProps.getProp2() == null;
        assert Objects.equals(appProp2, "some_default");
    }
    @Test
    void testSrcPropertyFromLibModule() {
        assert libConfigProps.getProp2() == null;
        assert Objects.equals(libProp2, "some_default");
    }

}
