package com.msp.tools.Entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SuperDomain implements Serializable {
    public Map<String, Object> toMap() {
        Field[] fields = this.getClass().getDeclaredFields();
        if(fields.length <= 0) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> result = new HashMap<String, Object>(fields.length);
        for(Field field: fields) {
            Object value;
            try {
                value = this.getClass().getDeclaredMethod("get" + upcase(field.getName())).invoke(this);
                if(isEmpty(value)) {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Column column = field.getDeclaredAnnotation(Column.class);
            if(column != null) {
                result.put(column.name(), value);
            }
        }
        return result;
    }

    protected String upcase(String str) {
        return str.substring(0,1).toUpperCase().concat(str.substring(1));
    }

    /**
     * @author: Almare
     * @date: 2019-06-17
     * @description: 是否为空值 true-空值  false-非空值
     */
    protected boolean isEmpty(Object object) {
        if(object == null) {
            return true;
        }
        if(object instanceof String) {
            if(object.toString().trim().equals("")) {
                return true;
            }
        }
        return false;
    }
}
