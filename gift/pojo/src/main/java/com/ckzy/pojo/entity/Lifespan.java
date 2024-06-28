package com.ckzy.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Deprecated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lifespan {

    private Long id;
    private Integer isAlways;
    private LocalDateTime lifespan;

}
