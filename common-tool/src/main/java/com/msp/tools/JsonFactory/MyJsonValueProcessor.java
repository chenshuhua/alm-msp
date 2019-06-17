package com.msp.tools.JsonFactory;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
 * @author: Almare
 * @date: 2019-06-17
 * @description:
 */
public class MyJsonValueProcessor implements JsonValueProcessor {

    private String format = "yyyy-MM-dd";

    public MyJsonValueProcessor() {
        super();
    }

    public MyJsonValueProcessor(String format) {
        super();
        this.format = format;
    }

    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return processValue(o);
    }

    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return processValue(o);
    }

    protected Object processValue(Object value) {
        if(value instanceof Date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            return simpleDateFormat.format(value);
        }
        return value;
    }
}
