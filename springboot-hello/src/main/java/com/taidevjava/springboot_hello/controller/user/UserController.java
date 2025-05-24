package com.taidevjava.springboot_hello.controller.user;

import com.taidevjava.springboot_hello.entity.user.UserEntity;
import com.taidevjava.springboot_hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/create")
    UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    @GetMapping("/users/search")
    UserEntity findByUserNameAndEmail(@RequestParam("name") String userName, @RequestParam String email) {
        System.out.println("userName:" + userName);
        return userService.findByUserNameAndEmail(userName, email);
    }

    @GetMapping("/users/getAll")
    Page<UserEntity> findAllUser(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBody = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBody);
        return userService.findAllUser(pageable);
    }

    @GetMapping("/users/searchPage")
    Page<UserEntity> findAllUserNamePage(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBody = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBody);
        return userService.findByUserName(name, pageable);
    }
}
