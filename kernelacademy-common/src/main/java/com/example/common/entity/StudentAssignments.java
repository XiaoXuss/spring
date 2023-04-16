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
@ApiModel(value="StudentAssignments对象", description="")
public class StudentAssignments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作业提交ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "学生id")
    private Integer studentId;

    @ApiModelProperty(value = "作业id")
    private Integer assignmentId;

    @ApiModelProperty(value = "学生提交的作业文件(URL)")
    private String filePath;

    @ApiModelProperty(value = "提交时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "作业得分")
    private BigDecimal score;

    @ApiModelProperty(value = "批改时间")
    private LocalDateTime gradedTime;


}
