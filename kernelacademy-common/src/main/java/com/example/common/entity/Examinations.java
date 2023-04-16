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
@ApiModel(value="Examinations对象", description="")
public class Examinations implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考试ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "考试所属课程")
    private Integer coursesId;

    @ApiModelProperty(value = "考试标题")
    private String title;

    @ApiModelProperty(value = "考试内容(URL)")
    private String content;

    @ApiModelProperty(value = "考试截止时间")
    private LocalDateTime deadline;

    @ApiModelProperty(value = "考试创建时间")
    private LocalDateTime createTime;


}
