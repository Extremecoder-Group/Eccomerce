package com.extremecoder.productservice.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryRegistrationRequest {

    @NotBlank
    @Length(max = 255)
    private String name;
    @Length(max = 500)
    private String description;
    @NotNull
    private Boolean isParent;
    private Long parentId;

}
