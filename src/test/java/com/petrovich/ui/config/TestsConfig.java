// src/test/java/com/petrovich/ui/config/TestsConfig.java

package com.petrovich.ui.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:credentials.properties")
public interface TestsConfig extends Config {
    String selenoidLogin();

    String selenoidPassword();

    @DefaultValue("CHROME")
    String browser();

    @DefaultValue("99.0")
    String version();

    @DefaultValue("https://petrovich.ru")
    String baseUrl();

    @DefaultValue("1920x1080")
    String resolution();

    @DefaultValue("false")
    boolean remote();
}
