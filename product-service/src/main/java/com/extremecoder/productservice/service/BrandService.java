package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.dto.Response;

public interface BrandService {
    Response save(BrandDto brandDto);
}
