package com.autobot.api.modules;

import java.util.Properties;

public class ConfigModule {

    private static Properties properties;
    private static ConfigModule configModule;

    private ConfigModule(){
        String filePath="src/main/resources/staging.properties";
        PropertyModule propertyModule=new PropertyModule();
        properties=propertyModule.propertyLoader(filePath);
    }

    public static ConfigModule getInstance(){
        if(configModule==null){
            configModule=new ConfigModule();
        } return configModule;
    }

    public String getGoRestBaseURI(){
        return properties.getProperty("goRestURI");
    }

}
