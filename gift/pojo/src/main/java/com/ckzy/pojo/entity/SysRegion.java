package com.ckzy.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRegion {

    private String regionId;
    private String regionName;
    private String regionShortName;
    private String regionCode;
    private String regionParentId;
    private Integer regionLevel;
}
