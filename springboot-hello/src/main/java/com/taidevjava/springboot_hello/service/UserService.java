package com.taidevjava.springboot_hello.service;

import com.taidevjava.springboot_hello.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();
    UserEntity create(UserEntity userEntity);
    UserEntity findByUserNameAndEmail(String userName, String email);

    Page<UserEntity> findByUserName(String userName, Pageable page);

    Page<UserEntity> findAllUser(Pageable page);
}
