package parent.utils;


import parent.constants.EnvType;

import java.util.Properties;

public class Configloader {
    private final Properties properties;
    private static Configloader configureloader;

    private Configloader() throws IllegalAccessException {
      properties=PropertyUtils.propertyLoader("src/test/resources/config.properties");

    }
    public static Configloader getInstance() throws IllegalAccessException {
        if(configureloader==null){
            configureloader=new Configloader();
        }
        return configureloader;
    }
    public String getBaseUrl(){
        String prop=properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg-config.properties file");
    }

}
