package com.extremecoder.productservice.service.impl;

import com.extremecoder.productservice.model.Product;
import com.extremecoder.productservice.repository.ProductRepository;
import com.extremecoder.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    @Lazy
    private RestTemplate template;

    @Autowired
    private ProductRepository productRepository;

    @Value("${microservice.file-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    @Override
    public List<Product> getList() {
        String imageResponse = template.getForObject(ENDPOINT_URL + "/file-service/image/", String.class);
        logger.info("FILE-SERVICE-RESPONSE: " + imageResponse);
        return productRepository.findAll();
    }
}
