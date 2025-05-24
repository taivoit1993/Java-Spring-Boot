package com.taidevjava.springboot_hello;

import com.taidevjava.springboot_hello.entity.feedy.FeedyEntity;
import com.taidevjava.springboot_hello.entity.user.CCCDEntity;
import com.taidevjava.springboot_hello.entity.user.UserEntity;
import com.taidevjava.springboot_hello.repository.FeedyRepository;
import com.taidevjava.springboot_hello.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedyRepository feedyRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToMany(){
        //1 User Entity
        UserEntity userEntity = new UserEntity();
        FeedyEntity feedyEntity = new FeedyEntity();
        userEntity.setUserName("test");
        userEntity.setEmail("test@test");

        feedyEntity.setTitle("feed");
        feedyEntity.setContent("feed Content");

        userEntity.setFeeddyList(List.of(feedyEntity));
        feedyEntity.setUser(userEntity);
        userRepository.save(userEntity);
//        feedyRepository.save(feedyEntity);
    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToOne(){
        UserEntity userEntity = new UserEntity();
        CCCDEntity cccdEntity = new CCCDEntity();

        userEntity.setUserName("test01");
        userEntity.setEmail("test01@test01");

        cccdEntity.setCccdName("312147577");

        userEntity.setCccdEntity(cccdEntity);

        userRepository.save(userEntity);
    }
}
