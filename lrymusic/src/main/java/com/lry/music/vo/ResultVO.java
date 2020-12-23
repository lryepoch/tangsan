package com.lry.music.vo;

import lombok.Data;

/**
 * 接口返回类
 * @param <T>
 */
@Data
public class ResultVO<T> {

    private int code;

    private String message;

    private T data;

}
