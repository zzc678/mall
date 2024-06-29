package com.ckzy.web.controller;

import com.ckzy.common.enumerate.Check;
import com.ckzy.common.enumerate.RNumber;
import com.ckzy.common.exception.BusinessException;
import com.ckzy.common.exception.SystemException;
import com.ckzy.common.result.Result;
import com.ckzy.pojo.dto.department.ConditionFindDepartmentDTO;
import com.ckzy.pojo.dto.department.SaveDepartmentDTO;
import com.ckzy.pojo.vo.department.ShowDepartmentListVO;
import com.ckzy.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/dept")
@Api(tags = "部门管理模块")
@Slf4j
@SuppressWarnings("all")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;


    /**
     * 展示部门列表
     * @return
     */
    @ApiOperation(value = "部门名称列表", notes = "在表单控件中展示部门名称列表，并返回部门编号，实现业务功能。")
    @GetMapping("/dptn/dropdown")
    public Result<?> deptList() {

        try {
            List<Map<String, String>> list =    departmentService.deptList();
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);
        } catch (Exception e) {

            throw new SystemException(Check.SYSTEM_EXCEPTION.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }


    /**
     * 展示部门负责人列表
     * @return
     */
    @GetMapping("/rpbt/dropdown")
    @ApiOperation(value = "部门负责人列表", notes = "在表单控件中展示部门负责人名称的列表，并返回部门负责人编号，实现业务功能。")
    public Result<?> deptResponsibilities() {

        try {
            List<Map<String, String>> list = departmentService.deptResponsibilities();

            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);

        } catch (Exception e) {
            throw new SystemException(Check.SYSTEM_EXCEPTION.getMessage(), Check.SYSTEM_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }

    @GetMapping("/list")
    @ApiOperation(value = "部门列表信息", notes = "在表格中展示部门信息。")
    public Result<?> listInfo() {

        try {
            List<ShowDepartmentListVO> list = departmentService.listInfo();
            log.info("数据=========》{}", list);
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);
        } catch (Exception e) {
            throw new SystemException(Check.EXCEPTION.getMessage(), Check.EXCEPTION.getCode());
        }

        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }


    @GetMapping("/condition/list")
    @ApiOperation(value = "条件查询", notes = "根据部门名称和部门编号进行条件查询。部门名称采用模糊查询策略，部门编号采用精确查询的策略。")
    public Result<?> conditionListInfo(@RequestBody ConditionFindDepartmentDTO data) {

        try {
            List<ShowDepartmentListVO> list = departmentService.conditionListInfo(data);
            log.info(list.toString());
            if (!list.isEmpty())
                return Result.success(RNumber.FIND_SUCCESS.ordinal(), list);
        } catch (Exception e) {
            throw new SystemException(Check.EXCEPTION.getMessage(), Check.EXCEPTION.getCode());
        }
        return Result.failed(RNumber.FIND_ERROR.ordinal());
    }


    @PostMapping("/adddept")
    @ApiOperation(value = "新增部门接口", tags = "返回JSON数据")
    public Result<?> saveDept(@Valid @RequestBody SaveDepartmentDTO data) {

        try {
            if (departmentService.saveDepartment(data))
                return Result.success(RNumber.SAVE_SUCCESS.ordinal(), null);
        } catch (Exception e) {
            throw new BusinessException(Check.BUSINESS_EXCEPTION.getMessage(), Check.BUSINESS_EXCEPTION.getCode());
        }

        return Result.failed(RNumber.SAVE_ERROR.ordinal());
    }

}
