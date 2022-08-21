package com.extremecoder.productservice;

import com.extremecoder.productservice.model.Product;
import com.extremecoder.productservice.repository.ProductRepository;
import com.extremecoder.productservice.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    @DisplayName("Product List")
    void productListTest() {

        when(productRepository.findAll()).thenReturn(Stream.of(Product.builder().productId(2L).build(),
                        Product.builder().productId(3L).build())
                .collect(Collectors.toList()));
        assertEquals(2, productService.getList().size());
    }

}
