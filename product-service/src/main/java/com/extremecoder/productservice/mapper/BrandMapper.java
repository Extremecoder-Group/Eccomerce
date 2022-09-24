package com.extremecoder.productservice.mapper;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toEntity(BrandDto brandDto);

    BrandDto toDto(Brand brand);
}
