package com.ckzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckzy.pojo.entity.SysRegion;

import java.util.List;

@SuppressWarnings("all")
public interface SysRegionService extends IService<SysRegion> {

    /**
     * 获取单个省份
     * @param provinceId
     * @return
     */
    SysRegion findByProvinceId(Integer provinceId);


    /**
     * 获取省份列表
     * @return
     */
    List<SysRegion> findProvinces();


    /**
     * 获取城市列表
     * @param parentId
     * @return
     */
    List<SysRegion> findCities(Integer parentId);


    /**
     * 获取区、县列表
     * @param parentId
     * @return
     */
    List<SysRegion> findDistricts(Integer parentId);
}
