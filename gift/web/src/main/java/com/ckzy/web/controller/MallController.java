package com.ckzy.web.controller;

import com.ckzy.common.enumerate.Check;
import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.exception.BusinessException;
import com.ckzy.common.result.Result;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import com.ckzy.service.MallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/mall")
@SuppressWarnings("all")
@Api(tags = "商城管理模块")

public class MallController {

    @Autowired
    private MallService mallService;


    /**
     * 添加商城
     * 除id外，所有属性不能为空。
     * @param data
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增商城", notes = "执行新增商城操作。")
    public Result<?> saveMall(@RequestBody @Valid AddMallDTO data) {

        try {
            if (mallService.addMall(data))
                return Result.success(RNumber.SAVE_SUCCESS.ordinal(), null);

        } catch (Exception e) {
            throw new BusinessException(Check.BUSINESS_EXCEPTION.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.SAVE_ERROR.ordinal());
    }


    /**
     * 批量删除商城
     * @param ids
     * @return
     */
    @DeleteMapping("/dels")
    @ApiOperation(value = "批量删除商城", notes = "执行批量删除商城操作。")
    public Result<?> removeMallList(@RequestBody List<Integer> ids) {

        try {
            if (mallService.deleteMalls(ids))
                return Result.success(RNumber.REMOVE_SUCCESS.ordinal(), null);
        } catch (Exception e) {
            throw new BusinessException(Check.BUSINESS_EXCEPTION.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.REMOVE_ERROR.ordinal());
    }

}
