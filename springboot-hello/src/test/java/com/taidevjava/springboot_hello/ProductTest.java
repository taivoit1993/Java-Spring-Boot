package com.taidevjava.springboot_hello;

import com.taidevjava.springboot_hello.entity.OrderEntity;
import com.taidevjava.springboot_hello.entity.ProductEntity;
import com.taidevjava.springboot_hello.repository.OrderRepository;
import com.taidevjava.springboot_hello.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void manyToManyTest(){
        ProductEntity p1 = new ProductEntity();
        ProductEntity p2 = new ProductEntity();
        ProductEntity p3 = new ProductEntity();
        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();

        p1.setProductName("<UNK>1");
        p1.setProductPrice(new BigDecimal("4.6"));
        p2.setProductName("<UNK>2");
        p2.setProductPrice(new BigDecimal("4.7"));
        p3.setProductName("<UNK>3");
        p3.setProductPrice(new BigDecimal("4.8"));
        p1.setOrderList(List.of(o1));
        p2.setOrderList(List.of(o1, o2));
        p3.setOrderList(List.of(o2));

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        orderRepository.save(o1);
        orderRepository.save(o2);
    }
}
