package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.dto.Response;
import com.extremecoder.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;


    @PostMapping
    public ResponseEntity<Response<Object, Object>> create(@Valid @RequestBody CategoryRegistrationRequest request) {

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
}
