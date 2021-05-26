package com.lryepoch.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
 * @since 2021-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment")
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "收藏类型（0歌曲1歌单）")
    private Boolean type;

    @ApiModelProperty(value = "歌曲id")
    private Integer songId;

    @ApiModelProperty(value = "  歌单id")
    private Integer songListId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "收藏时间")
    private Date createTime;

    @ApiModelProperty(value = "评论点赞数")
    private Integer up;


}
