package com.candy.controller;

import com.candy.exception.NoUserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器通知类，使用 @ControllerAdvice 注解，此类中的异常处理对
 * 所有的控制器抛出的一场都可以处理
 *
 */
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(NoUserException.class)
    public String noUserHandle() {
        return "noSuchUser";
    }

}
