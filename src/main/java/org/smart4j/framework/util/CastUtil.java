package org.smart4j.framework.util;

/**
 * 转型操作工具类
 */
public final class CastUtil {

    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static String castString(Object obj) {
        return castString(obj, "");
    }


    public static double castDouble(Object obj, double defaultValue) {

        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {

                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static double castDouble(Object obj) {
        return castDouble(obj, 0);
    }

    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }

    public static long castLong(Object obj, long defaultValue) {

        long longValue = defaultValue;

        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }

            }
        }
        return longValue;
    }

    public static int castInt(Object obj) {
        return castInt(obj, 0);
    }
    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {

                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }

            }
        }
        return intValue;
    }


    public static int castInit(Object obj) {
        return castInt(obj, 1);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }


    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }

}
