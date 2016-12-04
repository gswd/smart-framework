package org.smart4j.framework.test;

import org.smart4j.framework.util.ClassUtil;

import java.util.Set;

/**
 * Created by lihao on 2016-12-03.
 */
public class TestLoadClass {
    public static void main(String[] args) {
        Set<Class<?>> clazz = ClassUtil.getClassSet("org.apache.commons.lang3");
        System.out.println("clazz = " + clazz);
    }
}
