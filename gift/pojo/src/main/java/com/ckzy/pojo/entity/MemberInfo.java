package com.ckzy.pojo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberInfo {
    private String id;
    private String shortName;
    private String username;
    private String password;
    private String role;
    private String gender;
    private String deptId;
    private String position;
    private String directLeadership;
    private String intoPositionTime;
    private String telephone;
    private String createPersonId;
    private String createTime;
    private String status;

}
