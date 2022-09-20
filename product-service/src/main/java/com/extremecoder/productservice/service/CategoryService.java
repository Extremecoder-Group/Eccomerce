package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(CategoryRegistrationRequest request);

    List<Category> getCategories();
}
