package com.ckzy.pojo.vo.department;

import lombok.Data;

@Data
public class ShowDepartmentListVO {


    private String deptId;
    private String deptName;
    private String parentDept;
    private String deptResp;
    private String createPerson;
    private String createDatetime;
}
