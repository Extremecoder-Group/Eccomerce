package com.extremecoder.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class Response<T, U> {
    private Date timeStamp;
    private Integer statusCode;
    private String status;
    private String messageCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private U errors;
}
