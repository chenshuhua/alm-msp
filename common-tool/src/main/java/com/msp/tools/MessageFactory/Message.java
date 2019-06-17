package com.msp.tools.MessageFactory;

import com.msp.tools.Enums.ResponseCode;

/**
 * @author: Almare
 * @date: 2019-06-17
 * @description:
 */
public class Message {
    // 状态码
    private int ret;
    // 内容体
    private Object data;
    // 携带信息
    private String msg;

    public Message()
    {
    }

    public Message(Object data)
    {
        this.ret = ResponseCode.SUCCESS;
        this.data = data;
        this.msg = "success";
    }

    public Message(int ret, String msg)
    {
        this.ret = ret;
        this.msg = msg;
    }

    public Message(int ret, Object data, String msg)
    {
        this.ret = ret;
        this.data = data;
        this.msg = msg;
    }

    // 返回错误对象
    public static Message errorMessage()
    {
        return new Message(ResponseCode.ERROR, "system error");
    }

    public static Message errorMessage(int ret, String msg)
    {
        return new Message(ret, msg);
    }

    // 返回成功对象
    public static Message successMessage(Object object)
    {
        return new Message(ResponseCode.SUCCESS, object, "success");
    }

    public int getRet()
    {
        return ret;
    }

    public void setRet(int ret)
    {
        this.ret = ret;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "{" + "ret=" + ret + ", data=" + data + ", msg='" + msg + '\'' + '}';
    }
}
