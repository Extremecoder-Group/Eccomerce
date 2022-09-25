package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.CategoryDetail;
import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.model.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryRegistrationRequest request);

    List<CategoryEntity> getCategories();


    CategoryDetail getCategoryDetail(Long id);
}
