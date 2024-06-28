package com.ckzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckzy.dao.mapper.SysRegionMapper;
import com.ckzy.pojo.entity.SysRegion;
import com.ckzy.service.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("all")
public class SysRegionServiceImpl extends ServiceImpl<SysRegionMapper, SysRegion> implements SysRegionService {

    @Autowired
    private SysRegionMapper sysRegionMapping;

    /**
     * 获取单个省份
     * @param provinceId
     * @return
     */
    @Override
    public SysRegion findByProvinceId(Integer provinceId) {
        return sysRegionMapping.getByProvinceId(provinceId);
    }


    /**
     * 获取省份列表
     * @return
     */
    @Override
    public List<SysRegion> findProvinces() {
        return sysRegionMapping.getProvinces();
    }



    /**
     * 获取城市列表
     * @param parentId
     * @return
     */
    @Override
    public List<SysRegion> findCities(Integer parentId) {
        return sysRegionMapping.getCitiesOrDistricts(parentId);
    }

    /**
     * 获取区、县列表
     * @param parentId
     * @return
     */
    @Override
    public List<SysRegion> findDistricts(Integer parentId) {
        return sysRegionMapping.getCitiesOrDistricts(parentId);
    }
}
