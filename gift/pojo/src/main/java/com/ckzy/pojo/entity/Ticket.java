package com.ckzy.pojo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Ticket {

    @NotNull(message = "编号不能为空！")
    private String id;
    @NotBlank(message = "面值不能为空！")
    private String faceValue;
    @NotBlank(message = "积分不能为空！")
    private String integral;
}
