package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.dto.ApiResponse;
import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.service.BrandService;
import com.extremecoder.productservice.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ApiResponse saveBrand(@Valid @RequestBody BrandDto brandDto) {
        brandDto = brandService.save(brandDto);
        log.info("Saving brand with name {}", brandDto.getName());
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, String.join("Brand {} saved successfully",
                brandDto.getName()), brandDto);
    }
}
