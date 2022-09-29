package com.extremecoder.productservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParentCategoryDetail {
    public Long id;
    public String name;
    private String description;
}
