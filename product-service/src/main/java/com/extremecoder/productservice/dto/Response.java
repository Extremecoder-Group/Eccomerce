package com.extremecoder.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class Response<T> {
    private LocalDateTime timeStamp;
    private Integer statusCode;
    private String status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numberOfElement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long rowCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorResponseDto> errors;
}
