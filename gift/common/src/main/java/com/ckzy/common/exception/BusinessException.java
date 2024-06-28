package com.ckzy.common.exception;

public class BusinessException extends BaseException{
    public BusinessException(String message, Integer code) {
        super(message, code);
    }
}
