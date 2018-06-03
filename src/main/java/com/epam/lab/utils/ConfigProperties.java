package com.epam.lab.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.lab.utils.Constants.CONFIG_PROPERTIES;

public class ConfigProperties {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getTestProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
