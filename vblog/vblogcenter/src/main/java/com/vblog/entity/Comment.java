package com.vblog.entity;

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
 * @since 2021-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论时间")
    private Date publishTime;

    @ApiModelProperty(value = "文章id")
    private Integer aId;

    @ApiModelProperty(value = "父评论id")
    private Integer parentId;

    @ApiModelProperty(value = "评论用户id")
    private Integer uId;


}
