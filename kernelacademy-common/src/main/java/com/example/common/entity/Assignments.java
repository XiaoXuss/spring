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
 * 作业实体类
 * </p>
 *
 * @author xab
 * @since 2023-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Assignments对象", description="作业表")
public class Assignments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作业id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "发布教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "所属课程id")
    private Integer courseId;

    @ApiModelProperty(value = "作业标题")
    private String title;

    @ApiModelProperty(value = "作业描述")
    private String description;

    @ApiModelProperty(value = "截止日期")
    private LocalDateTime deadline;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
