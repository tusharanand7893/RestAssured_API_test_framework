package com.autobot.api.modules;

import java.io.*;
import java.util.Properties;

public class PropertyModule {

    public Properties propertyLoader(String filePath)  {
        Properties properties=new Properties();
        BufferedReader bufferedReader;
        try{
            bufferedReader=new BufferedReader(new FileReader(filePath));
            properties.load(bufferedReader);
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }return properties;

    }

}
