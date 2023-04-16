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
@ApiModel(value="Teachers对象", description="")
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师id")
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    @ApiModelProperty(value = "对应用户id")
    private String userId;

    @ApiModelProperty(value = "教师姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
