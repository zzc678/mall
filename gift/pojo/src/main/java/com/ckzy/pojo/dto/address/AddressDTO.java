package com.ckzy.pojo.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull
    private Integer id;
    @NotBlank
    private String province;
    @NotBlank
    private String city;
    @NotBlank
    private String district;
}
