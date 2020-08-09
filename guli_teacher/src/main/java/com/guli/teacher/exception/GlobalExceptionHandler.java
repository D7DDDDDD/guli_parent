package com.guli.teacher.exception;

import com.guli.common.result.Result;
import com.guli.common.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: guli_parent
 * @description: 统一异常处理类
 * @author: Mr.D
 * @create: 2020-06-10 03:12
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e ){
        e.printStackTrace();
        return Result.error().message("出错了");
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public Result ArithmeticExceptionError(Exception e){
        e.printStackTrace();
        return Result.error().message("除数不可以为0");
    }

    @ExceptionHandler(EduException.class)
    @ResponseBody
    public Result error(EduException e){
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().code(e.getCode()).message(e.getMsg());
    }
}
