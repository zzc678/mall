package com.ckzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckzy.dao.mapper.DepartmentMapper;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.dto.department.SaveDepartmentDTO;
import com.ckzy.pojo.entity.Department;
import com.ckzy.pojo.vo.department.ShowDepartmentListVO;
import com.ckzy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Map<String, String>> deptList() {
        return departmentMapper.deptList();
    }

    @Override
    public List<Map<String, String>> deptResponsibilities() {
        return departmentMapper.deptResponsibilities();
    }

    @Override
    public List<ShowDepartmentListVO> listInfo() {
        return departmentMapper.conditionSelectByDeptNameAndIdDepartment(null);
    }

    @Override
    public List<ShowDepartmentListVO> conditionListInfo(ConditionFindDepartmentDTO data) {
        return departmentMapper.conditionSelectByDeptNameAndIdDepartment(data);
    }

    @Override
    public Boolean saveDepartment(SaveDepartmentDTO data) {
        return departmentMapper.addDepartment(data) > 0;
    }
}
