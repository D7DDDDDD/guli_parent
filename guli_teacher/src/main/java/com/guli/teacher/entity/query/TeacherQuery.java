package com.guli.teacher.entity.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: guli_parent
 * @description: 条件查询的对象
 * @author: Mr.D
 * @create: 2020-06-07 20:59
 **/


@Data
public class TeacherQuery {
    @ApiModelProperty(value = "教师名称，模糊查询")
    private String name;
    @ApiModelProperty(value = "头衔1 高级讲师，头衔2 首席讲师")
    private Integer level;

    @ApiModelProperty(value = "创建时间", example = "2020-01-01 8:00:00")
    private String gmtCreate;

    @ApiModelProperty(value = "修改时间", example = "2020-01-01 8:00:00")
    private String gmtModified;

}
