package com.ckzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import com.ckzy.pojo.entity.Mall;

import java.util.List;

public interface MallService extends IService<Mall> {

    /**
     * 添加商城
     * @return
     */
    Boolean addMall(AddMallDTO data);

    /**
     * 批量删除商城
     * @param ids
     * @return
     */
    Boolean deleteMalls(List<Integer> ids);
}
