package com.extremecoder.productservice.exception;

public class InvalidRequestException extends BaseException {
    public InvalidRequestException(String message, String code) {
        super(message, code);
    }

    public InvalidRequestException(String message, String code, Throwable ex) {
        super(message, code, ex);
    }


}
