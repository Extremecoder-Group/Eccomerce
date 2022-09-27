package com.extremecoder.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class BrandDto {
    @NotBlank(message = "Must need to provide Brand name")
    private String name;
    private String alias;
    @NotBlank(message = "Must need to provide TradeMarkRegistration")
    private String trademarkRegistrant;
    @NotBlank(message = "Must need to provide Trademark Number")
    private String trademarkNumber;
}
