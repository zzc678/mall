package com.ckzy.web.controller;

import com.ckzy.common.enumerate.Check;
import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.exception.SystemException;
import com.ckzy.common.result.Result;
import com.ckzy.pojo.entity.MallType;
import com.ckzy.service.MallTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Api(tags = "商城类型模块")
@RequestMapping("/malltype")
public class MallTypeController {


    @Autowired
    private MallTypeService mallTypeService;

    @ApiOperation(value = "展示商城", notes = "将数据封装到表单控件中，返回商城编号。")
    @GetMapping("/list/dropdown")
    public Result<?> list() {

        try {
            List<MallType> list = mallTypeService.mallList();

            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);

        } catch (Exception e) {
            throw new SystemException(Check.SYSTEM_EXCEPTION.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }

}
