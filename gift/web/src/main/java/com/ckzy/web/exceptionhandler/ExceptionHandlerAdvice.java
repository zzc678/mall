package com.ckzy.web.exceptionhandler;


import com.ckzy.common.enumerate.Check;
import com.ckzy.common.exception.SystemException;
import com.ckzy.common.exception.BusinessException;
import com.ckzy.common.result.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
@SuppressWarnings("all")
public class ExceptionHandlerAdvice {

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public Result<?> doSystemException(SystemException e) {

        e.printStackTrace();
        return new Result<>(e.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> doBusinessException(BusinessException e) {

        e.printStackTrace();
        return new Result<>(e.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
    }

    /**
     * 自定义验证异常
     * 参数传值
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result<?> doBindException(BindException e) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach( item -> {
            errors.put(item.getField(), item.getDefaultMessage());
        });

        return new Result<>(Check.VALID_EXCEPTION.getMessage(), Check.VALID_EXCEPTION.getCode(), errors);
    }


    /**
     * 自定义验证异常
     * JSON传值
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> doMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach( item -> {
            errors.put(item.getField(), item.getDefaultMessage());
        });

        return new Result<>(Check.VALID_EXCEPTION.getMessage(), Check.VALID_EXCEPTION.getCode(), errors);
    }




    @ExceptionHandler(Exception.class)
    public Result<?> doException(Exception e) {

        e.printStackTrace();
        return new Result<>(e.getMessage(), Check.EXCEPTION.getCode());
    }

}
