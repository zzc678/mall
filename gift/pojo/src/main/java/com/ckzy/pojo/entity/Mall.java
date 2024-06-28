package com.ckzy.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@SuppressWarnings("all")
public class Mall {
    private Long id;
    private String name;
    private String description;
    private String ticketName;
    private LocalDateTime createTime;
    private String link;
    private String serviceTel;
    private String logo;
    private String certificates; // 二进制文件
    private Long faceValueId;
    private Long integralId;
    private Long mallTypeId;
    private String charter;
    private String serviceDeal;
    private Integer status;
    private Integer loginWay;
}