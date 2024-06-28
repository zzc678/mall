package com.ckzy.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.ckzy.pojo.dto.member.MemberInfoLoginDTO;
import com.ckzy.pojo.entity.MemberInfo;

public interface MemberInfoService extends IService<MemberInfo> {

    /**
     * 根据用户名和密码实现登录功能
     * @param data
     * @return
     */
    Boolean selectByUserNameAndPassword(MemberInfoLoginDTO data);
}
