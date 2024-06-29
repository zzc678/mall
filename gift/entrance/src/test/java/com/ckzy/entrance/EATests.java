package com.ckzy.entrance;


import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.result.Result;
import com.ckzy.dao.mapper.DepartmentMapper;
import com.ckzy.dao.mapper.MallMapper;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.dto.department.SaveDepartmentDTO;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import com.ckzy.pojo.vo.department.ShowDepartmentListVO;
import com.ckzy.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = EntranceApplication.class)
@Slf4j
class EATests {

    @Autowired
    private MallMapper mallMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentService departmentService;






    @Test
    public void t6() {
        log.info(departmentMapper.deptList().toString());
    }

    @Test
    public void t7() {
        log.info(departmentMapper.deptResponsibilities().toString());
    }

    @Test
    public void t8() {
        log.info(departmentMapper.conditionSelectByDeptNameAndIdDepartment(new ConditionFindDepartmentDTO()).toString());
    }


    @Test
    @SuppressWarnings("all")
    public void t9() {
        System.out.println(Result.failed(RNumber.MODIFY_ERROR.ordinal()));
    }


    @Test
    public void t10() {
        System.out.println(departmentService.listInfo());
    }

    @Test
    public void t11() {
        SaveDepartmentDTO cut = SaveDepartmentDTO.builder().deptName("剪刀石部").parentDept(1).deptResp(2).build();
        System.out.println(departmentMapper.addDepartment(cut));
    }

    @Test
    public void t12() {
        SaveDepartmentDTO cut = SaveDepartmentDTO.builder().deptName("剪刀石部").parentDept(1).deptResp(2).build();
        Boolean b = departmentService.saveDepartment(cut);

    }

    @Test
    public void t13() {
        List<ShowDepartmentListVO> showDepartmentListVOS = departmentMapper.conditionSelectByDeptNameAndIdDepartment(null);
        System.out.println(showDepartmentListVOS);

    }


}
