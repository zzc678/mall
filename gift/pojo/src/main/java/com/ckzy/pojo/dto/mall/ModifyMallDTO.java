package com.ckzy.pojo.dto.mall;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ModifyMallDTO {
    private Long id;
    private String name;
    private String link;
    private LocalDateTime create_time;
    private String description;
    private String ticketName;
    private Long faceValueId;
    private Long integralId;
    private String serviceTel;
    private String logo;
    private String certificates;
    private String loginWay;
    private String charter;
    private String serviceDeal;
    private String status;
    private Integer mallTypeId;
}

