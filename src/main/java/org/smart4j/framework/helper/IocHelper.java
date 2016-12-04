package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by lihao on 2016-12-04.
 */
public class IocHelper {
    static {
        //获取所有Bean类与Bean类实例之间的映射关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        if (CollectionUtil.isNotEmpty(beanMap)) {

            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                //获取Bean类定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpte(beanFields)) {
                    //遍历 bean field
                    for (Field beanField : beanFields) {
                        //判断当前Bean field 是否带有 Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在Bean Map 中获取 Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = BeanHelper.getBean(beanFieldClass);

                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }

        }
    }
}
