package org.smart4j.framework.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by lihao on 2016-11-21.
 */
public class StringUtil {

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static String[] splitString(String str, String separator) {

        return StringUtils.split(str, separator);
    }
}
