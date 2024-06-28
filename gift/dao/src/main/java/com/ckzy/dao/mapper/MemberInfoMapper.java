package com.ckzy.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckzy.pojo.dto.member.MemberInfoLoginDTO;
import com.ckzy.pojo.entity.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper extends BaseMapper<MemberInfo> {

    /**
     * 根据用户名和密码实现登录功能
     * @param data
     * @return
     */
    Integer selectByUserNameAndPassword(MemberInfoLoginDTO data);
}
