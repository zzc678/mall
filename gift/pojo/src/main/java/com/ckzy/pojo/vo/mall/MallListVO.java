package com.ckzy.pojo.vo.mall;


import lombok.Data;

@Data
public class MallListVO {

    private String name;
    private String description;
    private Long integralId;
    private String ticketName;
    private Integer loginWay;
    private Integer status;
    private String link;
}
