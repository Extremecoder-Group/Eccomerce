package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.dto.CategoryDto;
import com.extremecoder.productservice.mapper.MappingProvider;
import com.extremecoder.productservice.repository.CategoryRepository;
import com.extremecoder.productservice.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        log.info("Fetching list of categories");
        return MappingProvider.PRODUCT_MAPPER.toDtos(categoryRepository.findAll());
    }
}
