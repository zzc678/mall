package com.ckzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.entity.Department;
import com.ckzy.pojo.vo.department.ShowDepartmentListVO;

import java.util.List;
import java.util.Map;

public interface DepartmentService extends IService<Department> {

    /**
     * 获取部门列表
     *
     * @return
     */
    List<Map<String, String>> deptList();


    /**
     * 获取部门负责人列表
     *
     * @return
     */
    List<Map<String, String>> deptResponsibilities();


    /**
     * 展示列表详细信息
     * @return
     */
    List<ShowDepartmentListVO> listInfo();

    /**
     * 展示部门列表，并进行条件查询
     * @param data
     * @return
     */
    List<ShowDepartmentListVO> conditionListInfo(ConditionFindDepartmentDTO data);
}
