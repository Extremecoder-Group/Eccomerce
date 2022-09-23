package com.extremecoder.productservice.mapper;

import static org.mapstruct.factory.Mappers.getMapper;

public final class MappingProvider {
    private MappingProvider() {}
    public static final CategoryMapper PRODUCT_MAPPER = getMapper(CategoryMapper.class);
}
