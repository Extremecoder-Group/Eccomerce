package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.dto.Response;
import com.extremecoder.productservice.service.BrandService;
import com.extremecoder.productservice.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public Response saveBrand(@Valid @RequestBody BrandDto brandDto) {
        brandService.save(brandDto);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Brand Save Successfully", "");
    }
}
