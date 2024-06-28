package com.ckzy.common.enumerate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("all")
public enum Check {

    // crud success
    SAVE_SUCCESS("保存成功！", 2001),
    REMOVE_SUCCESS("删除成功", 2002),
    MODIFY_SUCCESS("修改成功！", 2003),
    FIND_SUCCESS("查询成功！", 2004),
    // crud error
    SAVE_ERROR("保存失败！", 5001),
    REMOVE_ERROR("删除失败！", 5002),
    MODIFY_ERROR("修改失败！", 5003),
    FIND_ERROR("查询失败！", 5004),
    // program exception
    BUSINESS_EXCEPTION("业务异常，请联系开发人员！", 6001),
    SYSTEM_EXCEPTION("系统异常，请联系运维人员！", 6002),
    EXCEPTION("您的网络状态不佳，请稍后重试...", 6003),
    VALID_EXCEPTION("数据不合法", 6004)
    ;

    private String message;
    private Integer code;

    Check(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
