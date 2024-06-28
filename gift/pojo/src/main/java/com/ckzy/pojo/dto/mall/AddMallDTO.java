package com.ckzy.pojo.dto.mall;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("all")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新增商城字段")
public class AddMallDTO {

    @ApiModelProperty(value = "用户编号")
    private Long id;

    @ApiModelProperty(value = "商城名称", example = "天天商城")
    @NotBlank(message = "商城名称不能为空！")
    private String name;

    @ApiModelProperty(value = "商城链接", example = "https://xx.com")
    @NotBlank(message = "商城链接不能为空！")
    private String link;

    @ApiModelProperty(value = "商城简介", example = "致力于提供用户安全稳定的服务。")
    @NotBlank(message = "商城简介不能为空！")
    private String description;

    @ApiModelProperty(value = "商城卡券", example = "夏日特惠")
    @NotBlank(message = "商城券名不能为空！")
    private String ticketName;

    @ApiModelProperty(value = "卡券面额", example = "元")
    @NotNull(message = "卡券面单位不能为空！")
    private Integer faceValueId;

    @ApiModelProperty(value = "卡券积分", example = "积分")
    @NotNull(message = "卡券积分价值不能为空！")
    private Integer integralId;

    @ApiModelProperty(value = "商城类型", example = "电影商城")
    @NotNull(message = "商城类型不能为空！")
    private Integer mallType;

}
