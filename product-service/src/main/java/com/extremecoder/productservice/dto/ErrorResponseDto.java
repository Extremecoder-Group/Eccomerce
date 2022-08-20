package com.extremecoder.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Setter
@Getter
@Builder
public class ErrorResponseDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
