package com.ckzy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckzy.dao.mapper.MallTypeMapper;
import com.ckzy.pojo.entity.MallType;
import com.ckzy.service.MallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallTypeServiceImpl extends ServiceImpl<MallTypeMapper, MallType> implements MallTypeService {


    @Autowired
    private MallTypeMapper mallTypeMapper;

    @Override
    public List<MallType> mallList() {
        return mallTypeMapper.getList();
    }
}
