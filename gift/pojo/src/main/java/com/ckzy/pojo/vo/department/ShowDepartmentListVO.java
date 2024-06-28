package com.ckzy.pojo.vo.department;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowDepartmentListVO {


    private String deptId;
    private String deptName;
    private String parentDept;
    private String deptResp;
    private String createPerson;
    private String createDatetime;
}
