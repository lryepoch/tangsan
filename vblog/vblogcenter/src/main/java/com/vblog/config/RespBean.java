package com.vblog.config;

/**
 * @author lryepoch
 * @date 2021/1/13 13:46
 * @description 通用返回对象
 */
public class RespBean {
    private String status;
    private String msg;

    public RespBean() {
    }

    public RespBean(String status, String msg) {

        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
