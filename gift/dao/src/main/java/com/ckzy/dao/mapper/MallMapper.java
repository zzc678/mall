package com.ckzy.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import com.ckzy.pojo.entity.Mall;
import com.ckzy.pojo.vo.mall.MallListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MallMapper extends BaseMapper<Mall> {

    /**
     * 添加商城
     * @return
     */
    Integer addMall(AddMallDTO data);

    Integer deleteMalls(@Param("ids") List<Integer> ids);

}
