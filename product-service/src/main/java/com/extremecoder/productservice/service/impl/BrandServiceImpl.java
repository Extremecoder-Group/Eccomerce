package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.model.Brand;
import com.extremecoder.productservice.repository.BrandRepository;
import com.extremecoder.productservice.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.extremecoder.productservice.mapper.MappingProvider.BRAND_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public BrandDto save(BrandDto brandDto) {
        /*TODO Brand Name can't be duplicate*/
        Brand brand = brandRepository.save(BRAND_MAPPER.toEntity(brandDto));
        log.info("Saved brand with Id {}", brand.getId());
        return BRAND_MAPPER.toDto(brand);
    }
}
