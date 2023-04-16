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
@ApiModel(value="Class对象", description="")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级id")
    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    @ApiModelProperty(value = "班级名")
    private String name;

    @ApiModelProperty(value = "所属年级")
    private String grade;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
