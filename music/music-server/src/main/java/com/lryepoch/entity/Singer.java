package com.lryepoch.entity;

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
 * @since 2021-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("singer")
@ApiModel(value="Singer对象", description="")
public class Singer implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sex;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "生日")
    private String birth;

    @ApiModelProperty(value = "地区")
    private String location;

    @ApiModelProperty(value = "介绍")
    private String introduction;


}
