package com.extremecoder.productservice.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final String code;
    private final String message;

    public BaseException(String message, String code, Throwable ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
    }

    public BaseException(String message, String code) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
