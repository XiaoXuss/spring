package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value="StudentsExaminations对象", description="")
public class StudentsExaminations implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考试提交ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "学生ID")
    private Integer studentId;

    @ApiModelProperty(value = "考试ID")
    private Integer examinationId;

    @ApiModelProperty(value = "提交内容")
    private String count;

    @ApiModelProperty(value = "提交时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "考试成绩")
    private BigDecimal score;

    @ApiModelProperty(value = "批改时间")
    private LocalDateTime gradedTime;


}
