package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lihao on 2016-12-04.
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        //获取所有Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                //获取Controller类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();

                if (ArrayUtil.isNotEmpte(methods)) {
                    // 遍历Controller类中的方法
                    for (Method method : methods) {
                        //判断当前方法是否有Acion注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //从Action注解中获得URL映射规则
                            Action action = method.getAnnotation(Action.class);

                            String mapping = action.value();

                            //验证URL映射规则

                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpte(array) && array.length == 2) {
                                    //获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];

                                    Request request = new Request(requestMethod, requestPath);

                                    Handler handler = new Handler(controllerClass, method);

                                    //初始化Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);

        return ACTION_MAP.get(request);
    }
}
