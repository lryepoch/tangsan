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
@TableName("song")
@ApiModel(value="Song对象", description="")
public class Song implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "歌手id")
    private Integer singerId;

    private String name;

    private String introduction;

    private Date createTime;

    private Date updateTime;

    @ApiModelProperty(value = "歌曲图片")
    private String pic;

    @ApiModelProperty(value = "歌词")
    private String lyric;

    @ApiModelProperty(value = "歌曲地址")
    private String url;


}
