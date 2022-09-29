package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.CategoryDetail;
import com.extremecoder.productservice.dto.CategoryRegistrationRequest;

import java.util.List;

public interface CategoryService {
    Long create(CategoryRegistrationRequest request);

    List<CategoryDetail> getAllCategories();


    CategoryDetail getCategory(Long id);
}
