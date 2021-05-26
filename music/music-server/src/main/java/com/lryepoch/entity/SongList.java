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
@TableName("song_list")
@ApiModel(value="SongList对象", description="")
public class SongList implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "歌单名称")
    private String title;

    @ApiModelProperty(value = "歌单图片")
    private String pic;

    @ApiModelProperty(value = "歌单介绍")
    private String introduction;

    @ApiModelProperty(value = "歌单风格")
    private String style;


}
