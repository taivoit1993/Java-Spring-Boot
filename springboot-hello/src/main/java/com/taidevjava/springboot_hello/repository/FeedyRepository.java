package com.taidevjava.springboot_hello.repository;

import com.taidevjava.springboot_hello.entity.feedy.FeedyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedyRepository extends JpaRepository<FeedyEntity, Long>  {
}
