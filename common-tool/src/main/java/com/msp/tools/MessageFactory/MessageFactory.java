package com.msp.tools.MessageFactory;

import com.msp.tools.JsonFactory.MyJsonValueProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author: Almare
 * @date: 2019-06-17
 * @description: 用于格式化返回消息
 */
public class MessageFactory
{
    private static JsonConfig jsonConfig = new JsonConfig();
    static
    {
        jsonConfig.registerJsonValueProcessor(Date.class, new MyJsonValueProcessor());
    }

    /**
     * @author: Almare
     * @date: 2019-06-17
     * @description: 返回对象的的消息
     */
    public static String getMessageObj(Object obj)
    {
        Message message = null;
        try
        {
            message = Message.successMessage(obj);
        } catch (Exception e)
        {
            message = Message.errorMessage();
            return JSONObject.fromObject(message, jsonConfig).toString();
        }
        return JSONObject.fromObject(message, jsonConfig).toString();
    }

    public static String getMessage(Message message)
    {
        return JSONObject.fromObject(message, jsonConfig).toString();
    }

    public static void sendJsonMessage(HttpServletResponse response, Message message)
    {
        response.setContentType("application/json; charset=utf-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(MessageFactory.getMessage(message));
            writer.close();
            response.flushBuffer();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getMessageObj(Object obj, int stateCode, String desc){
        Message message = null;
        try
        {
            message =new Message(stateCode, obj, desc);
        } catch (Exception e1)
        {
            message = Message.errorMessage();
            return JSONObject.fromObject(message, jsonConfig).toString();
        }
        return JSONObject.fromObject(message, jsonConfig).toString();
    }
}
