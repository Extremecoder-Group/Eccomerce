package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.dto.Response;
import com.extremecoder.productservice.mapper.BrandMapper;
import com.extremecoder.productservice.model.Brand;
import com.extremecoder.productservice.repository.BrandRepository;
import com.extremecoder.productservice.service.BrandService;
import com.extremecoder.productservice.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public Response save(BrandDto brandDto) {
        Brand brand = brandMapper.toEntity(brandDto);
        brand = brandRepository.save(brand);
        /*TODO Brand Name can't be duplicate*/
        if (brand != null)
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Brand Save Successfully", null);
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }
}
