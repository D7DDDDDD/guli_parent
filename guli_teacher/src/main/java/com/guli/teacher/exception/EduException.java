package com.guli.teacher.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: guli_parent
 * @description:
 * @author: Mr.D
 * @create: 2020-06-10 14:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "全局异常")
public class EduException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String msg;

    @Override
    public String toString() {
        return "EduException{" +
                "message=" + this.getMsg() +
                ", code=" + code +
                '}';

    }
}