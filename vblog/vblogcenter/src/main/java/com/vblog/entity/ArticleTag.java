package com.vblog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_article_tag")
@ApiModel(value="ArticleTag对象", description="")
public class ArticleTag implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer aId;

    private Integer tId;


}
