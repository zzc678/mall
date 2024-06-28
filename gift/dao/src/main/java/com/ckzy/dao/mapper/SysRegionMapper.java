package com.ckzy.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckzy.pojo.entity.SysRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@SuppressWarnings("all")
public interface SysRegionMapper extends BaseMapper<SysRegion> {


    /**
     * 获取单个省份
     * @param provinceId
     * @return
     */
    SysRegion getByProvinceId(@Param("pid") Integer provinceId);


    /**
     * 获取省份列表
     * @return
     */
    List<SysRegion> getProvinces();


    /**
     * 获取城市或区县列表
     * @param parentId
     * @return
     */
    List<SysRegion> getCitiesOrDistricts(Integer parentId);

}
