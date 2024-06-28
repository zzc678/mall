package com.ckzy.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("商城类型")
public class MallType {

    @ApiModelProperty(value = "商城编号")
    @NotNull(message = "商城编号")
    private Long id;

    @ApiModelProperty(value = "商城名称", example = "天天商城")
    @NotBlank(message = "商城名称")
    private String name;
}
