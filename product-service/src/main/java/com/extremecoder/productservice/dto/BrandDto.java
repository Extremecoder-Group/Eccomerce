package com.extremecoder.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandDto {
    private String name;
    private String alias;
    private String trademarkRegistrant;
    private String trademarkNumber;
}
