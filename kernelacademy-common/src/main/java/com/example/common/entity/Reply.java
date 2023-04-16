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
@ApiModel(value="Reply对象", description="")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回复ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "讨论id")
    private Integer discussionId;

    @ApiModelProperty(value = "回复内容")
    private String count;

    @ApiModelProperty(value = "回复者id")
    private Integer userId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
