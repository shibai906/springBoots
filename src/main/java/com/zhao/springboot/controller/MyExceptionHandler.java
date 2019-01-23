package com.zhao.springboot.controller;

import com.zhao.enums.ErrorEnum;
import com.zhao.json.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object handleException(Exception e) {
        return JSONResult.fail(ErrorEnum.SERVER.code,ErrorEnum.SERVER.errorMessage);
    }

}
