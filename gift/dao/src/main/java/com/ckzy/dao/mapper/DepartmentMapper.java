package com.ckzy.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.dto.department.SaveDepartmentDTO;
import com.ckzy.pojo.entity.Department;
import com.ckzy.pojo.vo.department.ShowDepartmentListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
@SuppressWarnings("all")
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取部门列表
     * @return
     */
//    List<String> deptList();

    List<Map<String, String>> deptList();

    /**
     * 获取部门负责人列表
     * @return
     */
    List<Map<String, String>> deptResponsibilities();


    /**
     * 展示部门列表
     * @param data
     * @return
     */
    List<ShowDepartmentListVO> conditionSelectByDeptNameAndIdDepartment(ConditionFindDepartmentDTO data);


    /**
     * 添加部门
     * @param data
     * @return
     */
    Integer addDepartment(SaveDepartmentDTO data);

}
