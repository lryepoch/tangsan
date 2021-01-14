package com.vblog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_article")
@ApiModel(value="Article对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "网页内容")
    private String htmlContent;

    @ApiModelProperty(value = "概要")
    private String summary;

    @ApiModelProperty(value = "分类id")
    private Integer cId;

    @ApiModelProperty(value = "作者id")
    private Integer uId;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    @ApiModelProperty(value = "0表示草稿箱，1表示已发表，2表示已删除")
    private Integer state;

    @ApiModelProperty(value = "浏览数")
    private Integer pageView;



    @ApiModelProperty(value = "标签")
    private String[] dynamicTags;

    private String nickname;
    private String cateName;

    private List<Tag> tags;
    private String stateStr;

}
