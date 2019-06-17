package com.msp.tools.JsonFactory;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;

/**
 * @author: Almare
 * @date: 2019-06-17
 * @description:
 */
public class JsonFactory {

    private static JsonConfig jsonConfig = new JsonConfig();
    static {
        jsonConfig.registerJsonValueProcessor(Date.class, new MyJsonValueProcessor());
    }

    public static String toJson(Object object) {
        return JSONObject.fromObject(object, jsonConfig).toString();
    }
}
