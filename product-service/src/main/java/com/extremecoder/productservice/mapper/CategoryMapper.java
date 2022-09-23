package com.extremecoder.productservice.mapper;

import com.extremecoder.productservice.dto.CategoryDto;
import com.extremecoder.productservice.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

// todo: remove this later
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtos(List<Category> categories);
    List<Category> toEntities(List<CategoryDto> categoryDtos);
}
