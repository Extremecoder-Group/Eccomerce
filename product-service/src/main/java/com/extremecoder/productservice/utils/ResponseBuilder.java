package com.extremecoder.productservice.utils;

import com.extremecoder.productservice.dto.ApiResponse;
import com.extremecoder.productservice.dto.FieldErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class ResponseBuilder {
    private ResponseBuilder() {
    }

    private static List<FieldErrorResponse> getCustomError(BindingResult result) {
        return result.getFieldErrors().stream().map(fieldError -> FieldErrorResponse.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build()).collect(Collectors.toList());
    }

    public static ApiResponse getFailureResponse(BindingResult result, String message) {
        return ApiResponse.builder()
                .message(message)
                .errors(getCustomError(result))
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(new Date())
                .build();
    }

    public static ApiResponse getFailureResponse(HttpStatus status, String message) {
        return ApiResponse.builder()
                .message(message)
                .status(status.getReasonPhrase())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(new Date())
                .build();
    }

    public static ApiResponse getSuccessResponse(HttpStatus status, String message, Object content) {
        return ApiResponse.builder()
                .message(message)
                .status(status.getReasonPhrase())
                .statusCode(status.value())
                .content(content)
                .timeStamp(new Date())
                .build();
    }

    public static ApiResponse getSuccessResponse(HttpStatus status, String message, Object content, int numberOfElement) {
        return ApiResponse.builder()
                .message(message)
                .status(status.getReasonPhrase())
                .statusCode(status.value())
                .content(content)
                .timeStamp(new Date())
                .build();
    }

}
