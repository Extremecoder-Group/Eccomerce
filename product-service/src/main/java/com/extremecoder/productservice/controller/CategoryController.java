package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.dto.Response;
import com.extremecoder.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;


    @PostMapping
    public ResponseEntity<Response<Object, Object>> create(@Valid @RequestBody CategoryRegistrationRequest request) {

        log.debug("request: " + request.toString());

        Response<Object, Object> response = Response.builder()
                .message("Success")
                .messageCode("1234")
                .status("OK")
                .statusCode(200)
                .content(service.create(request))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Response<Object, Object>> getCategory(@PathVariable Long id) {
        log.debug("request id: " + id);

        Response<Object, Object> response = Response.builder()
                .message("Success")
                .messageCode("1234")
                .status("OK")
                .statusCode(200)
                .content(service.getCategory(id))
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response<Object, Object>> getAllCategories() {
        log.debug("*** CategoryController.getAllCategories() ***");

        Response<Object, Object> response = Response.builder()
                .message("Success")
                .messageCode("1234")
                .status("OK")
                .statusCode(200)
                .content(service.getAllCategories())
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
