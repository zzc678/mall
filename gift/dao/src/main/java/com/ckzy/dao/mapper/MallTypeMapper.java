package com.ckzy.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckzy.pojo.entity.MallType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MallTypeMapper extends BaseMapper<MallType> {

    /**
     * 获取商城类型列表
     * @return
     */
    List<MallType> getList();
}
