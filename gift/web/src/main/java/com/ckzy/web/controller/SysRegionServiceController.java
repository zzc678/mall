package com.ckzy.web.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ckzy.common.annotation.NotIncludeSwagger;
import com.ckzy.common.enumerate.Check;
import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.exception.BusinessException;
import com.ckzy.common.exception.SystemException;
import com.ckzy.common.result.Result;
import com.ckzy.common.utils.JWTUtils;
import com.ckzy.pojo.dto.address.AddressDTO;
import com.ckzy.pojo.entity.SysRegion;
import com.ckzy.service.SysRegionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jnlp.ClipboardService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/address")
@SuppressWarnings("all")
@Slf4j
@Api(tags = "地域管理模块")
public class SysRegionServiceController {

    @Autowired
    private SysRegionService sysRegionService;


    /**
     * 获取省份列表
     * 测试通过
     * http://localhost:8080/address/showProvinces
     * @return
     */
    @GetMapping("/showProvinces")
    public Result<?> showProvince() {
        List<SysRegion> list;

        try {
            list = sysRegionService.findProvinces();
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);
        } catch (Exception e) {
            throw new SystemException(Check.SYSTEM_EXCEPTION.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }

    /**
     * 获取城市列表
     * 测试通过
     * http://localhost:8080/address/showCities/1000000
     * @param provinceId
     * @return
     */
    @GetMapping("/showCities/{provinceId}")
    public Result<?> showCities(@PathVariable Integer provinceId) {

        List<SysRegion> list;

        try {

            list = sysRegionService.findCities(provinceId);

            // 未抛出异常，且集合中有数据，则返回成功。
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);

        } catch (Exception e) {
            throw new BusinessException("业务异常", Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }

    /**
     * 展示所有的区、县
     * 测试通过
     * http://localhost:8080/address/showDistrict/1000151
     * @param cityId
     * @return
     */
    @GetMapping("/showDistrict/{cityId}")
    public Result<?> showDistrict(@PathVariable Integer cityId) {


        List<SysRegion> list;
        try {

            list = sysRegionService.findDistricts(cityId);
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);

        } catch (Exception e) {
            throw new BusinessException("业务异常", Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }
}
