package com.ckzy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckzy.dao.mapper.MallMapper;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import com.ckzy.pojo.entity.Mall;
import com.ckzy.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallServiceImpl extends ServiceImpl<MallMapper, Mall> implements MallService {

    @Autowired
    private MallMapper mallMapper;


    @Override
    public Boolean addMall(AddMallDTO data) {

        return mallMapper.addMall(data) > 0;
    }

    @Override
    public Boolean deleteMalls(List<Integer> ids) {
        return mallMapper.deleteMalls(ids) > 0;
    }
}
