package com.ckzy.web.controller;

import com.ckzy.common.enumerate.Check;
import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.exception.BusinessException;
import com.ckzy.common.result.Result;
import com.ckzy.common.utils.JWTUtils;
import com.ckzy.pojo.dto.member.MemberInfoLoginDTO;
import com.ckzy.pojo.entity.MemberInfo;
import com.ckzy.service.MallService;
import com.ckzy.service.MemberInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@Api(tags = "成员管理模块")
@RequestMapping("/load")
public class MemberInfoController {


    @Autowired
    private MemberInfoService memberInfoService;

    @ApiOperation(value = "成员登录", notes = "传入JSON数据")
    @PostMapping("/login")
    public Result<?> login( @Valid @ApiParam(name = "登录对象", value = "实体类型") @RequestBody MemberInfoLoginDTO data) {

        Map<String, String> token = new HashMap<>();
        // 暂无claim，传入空HashMap。不能传null。
        token.put("token", JWTUtils.getToken(new HashMap<>()));

        try {

            if (memberInfoService.selectByUserNameAndPassword(data))
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), token);

        } catch (Exception e) {
            throw new BusinessException(Check.BUSINESS_EXCEPTION.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }
}
