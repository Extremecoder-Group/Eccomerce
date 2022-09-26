package com.extremecoder.productservice.mapper;

import com.extremecoder.productservice.dto.BrandDto;
import com.extremecoder.productservice.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    Brand toEntity(BrandDto brandDto);

    BrandDto toDto(Brand brand);

    List<BrandDto> toDtos(List<Brand> brands);

    List<Brand> toEntities(List<BrandDto> brandDtos);
}
