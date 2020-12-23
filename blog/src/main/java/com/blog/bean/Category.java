package com.blog.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lryepoch
 * @date 2020/5/27 16:53
 * @description TODO
 */
@Data
public class Category {
    private Integer id;
    private String cateName;
    private Timestamp createTime;

}
