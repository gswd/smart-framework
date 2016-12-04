package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * Created by lihao on 2016-12-04.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
