package com.calculator.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyLoader {

    private static PropertyLoader singleton = null;;
    private Properties properties;
    private final Logger logger = Logger.getLogger(PropertyLoader.class);

    public Logger getLogger() {
        return logger;
    }

    private PropertyLoader() {
        properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getResourceAsStream("/default.properties"));
            properties.putAll(System.getProperties());
        } catch (Exception e) {
            getLogger().error(e.getMessage());
        }
    }

    public static PropertyLoader getInstance() {
        if (singleton == null) {
            singleton = new PropertyLoader();
        }
        return singleton;
    }

    public static void main(String[] args) {
         try {
             PropertyLoader loader = new PropertyLoader();
             loader.getProperties().store(System.out, "Hi");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public Properties getProperties() {
        return properties;
    }
}
