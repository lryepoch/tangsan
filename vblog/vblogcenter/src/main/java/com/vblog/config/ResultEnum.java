package com.vblog.config;


/**
 * @author lryepoch
 * @date 2020/5/27 15:57
 * @description TODO
 */
public enum ResultEnum {
    //请求成功
    SUCCESS(200,"操作成功"),
    //业务错误
    ERR(400,"操作失败"),
    //未认证
    UNAUTHORIZED(401,"未认证"),

    UNCONNECT(402,"未连接"),

    NO_DATA(403,"数据为空"),

    NOT_FOUND(404,"接口不存在"),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500,"稍等片刻，管理员正在努力恢复中");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }


}
