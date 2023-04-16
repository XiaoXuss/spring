package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Discussions对象", description="")
public class Discussions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讨论ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "讨论主题")
    private String topic;

    @ApiModelProperty(value = "讨论内容")
    private String content;

    @ApiModelProperty(value = "发布者id")
    private Integer userId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
