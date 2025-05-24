package com.taidevjava.springboot_hello.repository;
import com.taidevjava.springboot_hello.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
