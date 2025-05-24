package com.taidevjava.springboot_hello.service;

import com.taidevjava.springboot_hello.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity productEntity);

    List<ProductEntity> findAllProducts();
}
