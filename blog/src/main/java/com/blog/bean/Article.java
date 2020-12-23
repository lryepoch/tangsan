package com.blog.bean;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/27 16:53
 * @description TODO
 */
@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String htmlContent;
    private String summary;
    private Integer cid;
    private Integer uid;
    private Timestamp publishTime;
    private Timestamp editTime;
    private Integer state;
    private Integer pageView;

    private String[] dynamicTags;
    private List<Tag> tags;
    private String nickname;
    private String cateName;
}
