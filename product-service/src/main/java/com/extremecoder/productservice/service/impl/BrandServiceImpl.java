package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.mapper.BrandMapper;
import com.extremecoder.productservice.mapper.MappingProvider;
import com.extremecoder.productservice.model.Brand;
import com.extremecoder.productservice.repository.BrandRepository;
import com.extremecoder.productservice.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public void save(BrandDto brandDto) {
        Brand brand = MappingProvider.BRAND_MAPPER.toEntity(brandDto);
        /*TODO Brand Name can't be duplicate*/
        brandRepository.save(brand);
        log.info("Saved Brand With Id {}", brand.getId());
    }
}
