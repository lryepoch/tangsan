package com.imooc.minipro.handler;

import lombok.Data;

@Data
public class ResponseResult {

    /**
     * 请求状态
     */
    private boolean code;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public ResponseResult(boolean code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(boolean code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(boolean code) {
        this.code = code;
    }

}
