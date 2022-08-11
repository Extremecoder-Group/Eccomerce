package com.extremecoder.productservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global Exception Handler
 *
 * @author Badrul
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String CONTENT_TYPE = HttpHeaders.CONTENT_TYPE;

    /**
     * HandleHttpMediaTypeError
     *
     * @param ex Exception
     * @return Response Entity
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class})
    public final ResponseEntity<Object> handleHttpMediaTypeError(Exception ex) {
        HttpStatus httpStatus = ex instanceof HttpMediaTypeNotSupportedException ?
                HttpStatus.UNSUPPORTED_MEDIA_TYPE : HttpStatus.NOT_ACCEPTABLE;
        log.error("{}", ex);
        return ResponseEntity
                .status(httpStatus)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    /**
     * Handle Http Message Not Readable Error
     *
     * @param ex Exception
     * @return Response Entity
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public final ResponseEntity<Object> handleHttpMessageNotReadableError(Exception ex) {
        log.error("{}", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(ex.getMessage());
    }

    /**
     * Handle Resource Not Found Exception
     *
     * @param ex NoHandlerFoundException
     * @return Response Entity
     */
    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(NoHandlerFoundException ex) {
        // todo: modify response
        log.error("{}", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body("");
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public final ResponseEntity<Object> handleMethodNotAllowedException(Exception ex) {
        // todo: modify response
        log.error("{}", ex);
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    /**
     * Handle Required request parameter response entity.
     *
     * @return Response Entity
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public final ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        // todo: modify response
        log.error("{}", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Handle Illegal Argument Exception
     *
     * @param ex IllegalArgumentException
     * @return Response Entity
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<?> handleIllegalArgumentException(Throwable ex) {
        // todo: modify response
        log.error("{}", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Handle internal error.
     *
     * @param ex of type {@link RuntimeException}
     * @return the response entity
     */
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleInternalException(Throwable ex) {
        // todo: modify response
        log.error("{}", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * Handle Bind Exception
     * -->
     *
     * @param ex BindException
     * @return the response entity
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity<Object> handleBindException(BindException ex) {
        // todo: modify response
        log.error(ex.getMessage());

        Map<String, Object> body = new HashMap<>();

        //Get all errors
        List<String> errors = new ArrayList<>();

        for (ObjectError allError : ex.getBindingResult().getAllErrors()) {
            if (allError instanceof FieldError) {
                errors.add(((FieldError) allError).getField() + " " + allError.getDefaultMessage());
            } else if (allError instanceof ObjectError) {
                errors.add(allError.getDefaultMessage());
            }
        }

        body.put("message", errors);
        log.error("errors: " + errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //todo prepare common error response method()
}
