package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.CategoryDetail;
import com.extremecoder.productservice.dto.CategoryRegistrationRequest;

import java.util.List;

public interface CategoryService {
    Long create(CategoryRegistrationRequest request);

    Long update(CategoryRegistrationRequest request, Long id);

    List<CategoryDetail> getAllCategories();

    CategoryDetail getCategory(Long id);
}
