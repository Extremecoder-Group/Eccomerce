package com.extremecoder.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class ApiResponse<T, U> {
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;
    public static final int OK = 4;
    public static final int TOO_BUSY = 5;
    public static final int EXPIRED = 6;
    public static final int INTERNAL_SERVER_ERROR = 7;

    private Date timeStamp;
    private Integer statusCode;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String messageCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private U errors;

    public static String translateStatus(int code) {
        String status;
        switch (code) {
            case ERROR:
                status = "error";
                break;
            case WARNING:
                status = "warning";
                break;
            case INFO:
                status = "info";
                break;
            case OK:
                status = "ok";
                break;
            case TOO_BUSY:
                status = "too busy";
                break;
            case EXPIRED:
                status = "expired";
                break;
            case INTERNAL_SERVER_ERROR:
                status = "internal server error";
                break;
            default:
                status = "unknown";
                break;
        }

        return status;
    }
}
