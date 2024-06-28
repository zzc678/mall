package com.ckzy.entrance;


import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.result.Result;
import com.ckzy.dao.mapper.DepartmentMapper;
import com.ckzy.dao.mapper.MallMapper;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.dto.mall.AddMallDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class EATests {

    @Autowired
    private MallMapper mallMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    @Test
    public void t1() {

        AddMallDTO data = new AddMallDTO();
        data.setId(null);
        data.setName("商城名");
        data.setLink("链接");
        data.setDescription("描述");
        data.setTicketName("票名");
        data.setMallTypeId(1L);
        data.setFaceValueId(2L);
        data.setIntegralId(1L);
        System.out.println(mallMapper.addMall(data));
    }



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
}
