package com.extremecoder.productservice.exception;

/**
 * For HTTP 404 error
 */
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String message, String code, Throwable ex) {
        super(message, code, ex);
    }

    public ResourceNotFoundException(String message, String code) {
        super(message, code);
    }
}
