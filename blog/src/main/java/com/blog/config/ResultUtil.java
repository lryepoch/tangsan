package com.blog.config;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lryepoch
 * @date 2020/5/27 15:45
 * @description TODO
 */
@Data
@Builder
public class ResultUtil implements Serializable {
    private boolean status;
    private Integer code;
    private String msg;
    private Object data;
    //是否登录
//    private boolean isLogin;

    public static ResultUtil success(Object data){
        return ResultUtil.builder().status(true).code(ResultEnum.SUCCESS.getCode()).msg(ResultEnum.SUCCESS.getMsg()).data(data).build();
    }

    public static ResultUtil success(){
        return success(null);
    }

    public static ResultUtil fail(Integer code, String msg){
        return ResultUtil.builder().status(false).code(code).msg(msg).build();
    }

    public static ResultUtil fail(ResultEnum resultEnum){
        return ResultUtil.builder().code(resultEnum.getCode()).msg(resultEnum.getMsg()).build();
    }

}
