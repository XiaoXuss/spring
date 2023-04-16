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
@ApiModel(value="Courses对象", description="")
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "所属教师")
    private Integer teacherId;

    @ApiModelProperty(value = "课程名")
    private String name;

    @ApiModelProperty(value = "所属班级")
    private Integer classId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
