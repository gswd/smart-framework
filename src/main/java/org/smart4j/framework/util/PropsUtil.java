package org.smart4j.framework.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties props = null;

        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }

            props = new Properties();
            props.load(is);

        } catch (Exception e) {
            LOGGER.error("close input stream failure", e);
        }

        return props;

    }

    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.contains(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.contains(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if(props.contains(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

}
