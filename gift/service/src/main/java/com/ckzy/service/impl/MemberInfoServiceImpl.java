package com.ckzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckzy.dao.mapper.MemberInfoMapper;
import com.ckzy.pojo.dto.member.MemberInfoLoginDTO;
import com.ckzy.pojo.entity.MemberInfo;
import com.ckzy.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo> implements MemberInfoService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public Boolean selectByUserNameAndPassword(MemberInfoLoginDTO data) {
        return memberInfoMapper.selectByUserNameAndPassword(data) > 0;
    }
}
