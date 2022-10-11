package com.extremecoder.productservice.service;

import com.extremecoder.productservice.dto.CategoryDetail;
import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.model.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Long create(CategoryRegistrationRequest request);

    Long update(CategoryRegistrationRequest request, Long id);

    List<CategoryDetail> getAllCategories();

    CategoryDetail getCategory(Long id);

    void delete(Long id);

    List<CategoryEntity> categoryListWithPaginationAndSorting(Optional<Integer> offSet,
                                                              Optional<Integer> pageSize,
                                                              Optional<String> sortedField,
                                                              Optional<String> sortedDirection);
}
