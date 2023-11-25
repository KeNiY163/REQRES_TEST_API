package config;

import org.aeonbits.owner.Config;

@ApiConfig.Sources({
        "classpath:api.properties"
})
public interface ApiConfig extends Config {

    @Config.Key("baseUri")
    String BaseUri();

    @Key("basePath")
    String BasePath();


}
