package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.dto.CategoryRegistrationRequest;
import com.extremecoder.productservice.model.Category;
import com.extremecoder.productservice.repository.CategoryRepository;
import com.extremecoder.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryRegistrationRequest request) {

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .isParent(request.getIsParent())
                .build();

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }
}
