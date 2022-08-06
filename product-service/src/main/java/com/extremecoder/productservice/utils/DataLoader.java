package com.extremecoder.productservice.utils;

import com.extremecoder.productservice.model.Category;
import com.extremecoder.productservice.model.ImageInformation;
import com.extremecoder.productservice.model.Product;
import com.extremecoder.productservice.repository.CategoryRepository;
import com.extremecoder.productservice.repository.ImageInfoRepository;
import com.extremecoder.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageInfoRepository imageInfoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        ImageInformation fruitsVegetableImage = new ImageInformation(null, 1L, "1");
        imageInfoRepository.save(fruitsVegetableImage);
        ImageInformation fruitsImage = new ImageInformation(null, 2L, "2");
        imageInfoRepository.save(fruitsImage);
        ImageInformation bananaImage = new ImageInformation(null, 3L, "3");
        imageInfoRepository.save(bananaImage);
        Category fruitsVegetablesCat = new Category(null, "Fruits & Vegetables", fruitsVegetableImage, null);
        categoryRepository.save(fruitsVegetablesCat);
        Category fruitsCategory = new Category(null, "Fruits", fruitsImage, fruitsVegetablesCat);
        categoryRepository.save(fruitsCategory);
        Product product1 = new Product(null, "Banana", "Banana is the most popular fresh fruit in all over the world. It has lots of variety. ", bananaImage, fruitsCategory);
        productRepository.save(product1);
    }
}
