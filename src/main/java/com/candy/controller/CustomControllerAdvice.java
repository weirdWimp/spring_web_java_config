package com.candy.controller;

import com.candy.exception.Error;
import com.candy.exception.NameNotFoundException;
import com.candy.exception.NoUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 控制器通知类，使用 @ControllerAdvice 注解，此类中的异常处理对
 * 所有的控制器抛出的异常都可以处理
 *
 */
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(NoUserException.class)
    public String noUserHandle() {
        return "noSuchUser";
    }

    @ExceptionHandler(NameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error nameNotFoundHandle(NameNotFoundException exception) {
        return new Error(4, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error nameNotFoundHandle(HttpMessageNotReadableException exception) {
        exception.printStackTrace();
        return new Error(4, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error nameNotFoundHandle(HttpMessageNotWritableException exception) {
        exception.printStackTrace();
        return new Error(4, exception.getMessage());
    }
}
