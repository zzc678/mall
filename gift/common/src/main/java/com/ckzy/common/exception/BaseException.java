package com.ckzy.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
