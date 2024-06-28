package com.ckzy.pojo.dto.department;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiOperation("添加部门")
public class SaveDepartmentDTO {

    @NotBlank(message = "部门名称不能为空！")
    @ApiModelProperty("部门名称")
    private String deptName;

    @NotNull(message = "上级部门不能为空！")
    @ApiModelProperty("上级部门")
    private Integer parentDept;

    @NotNull(message = "部门负责人不能为空！")
    @ApiModelProperty("部门负责人")
    private Integer deptResp;
}
