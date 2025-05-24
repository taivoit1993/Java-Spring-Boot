package com.taidevjava.springboot_hello.service.impl;

import com.taidevjava.springboot_hello.entity.user.UserEntity;
import com.taidevjava.springboot_hello.repository.UserRepository;
import com.taidevjava.springboot_hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByUserNameAndEmail(String userName, String email) {
        return userRepository.findByUserNameAndEmail(userName, email);
    }

    @Override
    public Page<UserEntity> findByUserName(String userName, Pageable page) {
        return userRepository.findByUserName(userName, page);
    }

    @Override
    public Page<UserEntity> findAllUser(Pageable page) {
        return userRepository.findAll(page);
    }
}
