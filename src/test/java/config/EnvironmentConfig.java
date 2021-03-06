package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface EnvironmentConfig extends Config {

    @Key("webDriverUrl")
    String webDriverUrl();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

}
