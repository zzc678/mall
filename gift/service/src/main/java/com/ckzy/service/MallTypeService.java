package com.ckzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckzy.pojo.entity.MallType;

import java.util.List;

public interface MallTypeService extends IService<MallType> {
    /**
     * 获取商城类型列表
     * @return
     */
    List<MallType> mallList();
}
