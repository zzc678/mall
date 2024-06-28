package com.ckzy.common.result;

import com.ckzy.common.enumerate.Check;
import com.ckzy.common.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private String message;
    private Integer code;
    private T data;

    public Result(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public Result(String message, Integer code) {
        this.message = message;
        this.code = code;
        this.data = null;
    }


    /**
     * 请求失败的接口协议
     * @param val
     * @return
     */
    public static Result<?> failed(Integer val) {
        synchronized (Result.class) {
            switch (val) {
                case 0:
                    return new Result<>(Check.SAVE_ERROR.getMessage(), Check.SAVE_ERROR.getCode());
                case 1:
                    return new Result<>(Check.REMOVE_ERROR.getMessage(), Check.REMOVE_ERROR.getCode());
                case 2:
                    return new Result<>(Check.MODIFY_ERROR.getMessage(), Check.MODIFY_ERROR.getCode());
                case 3:
                    return new Result<>(Check.FIND_ERROR.getMessage(), Check.FIND_ERROR.getCode());
                case 4:
                    return new Result<>(Check.SYSTEM_EXCEPTION.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
                case 5:
                    return new Result<>(Check.BUSINESS_EXCEPTION.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
                case 6:
                    return new Result<>(Check.EXCEPTION.getMessage(), Check.EXCEPTION.getCode());
                case 7:
                    return new Result<>(Check.VALID_EXCEPTION.getMessage(), Check.VALID_EXCEPTION.getCode());
                default:
                    throw new BusinessException("请规范编码！", -400);
            }
        }
    }

    /**
     * 请求成功的接口协议
     * @param val
     * @param data
     * @return
     */
    public static Result<?> success(Integer val, Object data) {

        synchronized (Result.class) {
            switch (val) {
                case 8:
                    return new Result<>(Check.SAVE_SUCCESS.getMessage(), Check.SAVE_SUCCESS.getCode(), data);
                case 9:
                    return new Result<>(Check.REMOVE_SUCCESS.getMessage(), Check.REMOVE_SUCCESS.getCode(), data);
                case 10:
                    return new Result<>(Check.MODIFY_SUCCESS.getMessage(), Check.MODIFY_SUCCESS.getCode(), data);
                case 11:
                    return new Result<>(Check.FIND_SUCCESS.getMessage(), Check.FIND_SUCCESS.getCode(), data);
                default:
                    throw new BusinessException("请规范编码！", -400);
            }
        }
    }

    /**
     * 自定义接口协议
     * @param message
     * @param code
     * @param data
     * @return
     */
    public static Result<?> custom(String message, Integer code, Object data) {
        synchronized (Result.class) {
            return new Result<>(message, code, data);
        }
    }

}
