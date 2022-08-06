package com.extremecoder.productservice.controller;

import com.extremecoder.productservice.model.Product;
import com.extremecoder.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getList() {
        return productService.getList();
    }


}
