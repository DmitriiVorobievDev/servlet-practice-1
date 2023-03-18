package com.dvdev.http.mvc.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("C:\\IntelijWorkspace\\workspace1\\servlet-practice-1\\servlet-practice-1\\resources\\application.properties")) {
            PropertiesUtil.PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private PropertiesUtil() {
//    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}