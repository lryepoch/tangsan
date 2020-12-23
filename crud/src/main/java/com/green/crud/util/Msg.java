package com.green.crud.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Msg {
    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 存放用户返回给浏览器的数据
     */
    private Map<String, Object> data = new HashMap<>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("处理成功");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理失败");
        return msg;
    }

    /**
     * 链式操作
     *
     * @param key
     * @param value
     * @return
     */
    public Msg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

}
