package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.model.Product;
import com.extremecoder.productservice.service.ProductService;
import com.extremecoder.productservice.utils.UrlConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getList() {
        return productService.getList();
    }
}
