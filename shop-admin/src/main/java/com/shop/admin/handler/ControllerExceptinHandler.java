package com.shop.admin.handler;

import com.shop.admin.result.BaseResult;
import com.shop.admin.result.WebResult;
import com.shop.common.entity.enums.SysResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptinHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResult handle(RuntimeException e){
        return new WebResult(SysResultCodeEnum.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handle(Exception e){

        return new WebResult(SysResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }


}
