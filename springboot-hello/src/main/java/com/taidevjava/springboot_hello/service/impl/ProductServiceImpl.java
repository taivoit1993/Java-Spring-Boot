package com.taidevjava.springboot_hello.service.impl;

import com.taidevjava.springboot_hello.entity.ProductEntity;
import com.taidevjava.springboot_hello.repository.ProductRepository;
import com.taidevjava.springboot_hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }
}
