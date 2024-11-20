package org.example;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

public class PropertiesLoader {
    private static Configuration configuration;

    static {
        try {
            Configurations configs = new Configurations();
            configuration = configs.properties(new File("src/test/resources/application.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Не вдалося завантажити properties-файл", e);
        }
    }

    public static String getProperty(String key) {
        return configuration.getString(key);
    }

    public static int getIntProperty(String key) {
        return configuration.getInt(key);
    }
}

