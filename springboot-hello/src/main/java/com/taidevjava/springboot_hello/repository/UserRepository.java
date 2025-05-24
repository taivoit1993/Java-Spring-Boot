package com.taidevjava.springboot_hello.repository;

import com.taidevjava.springboot_hello.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    /*
    * find user by username and email
     */
    UserEntity findByUserNameAndEmail(String userName, String email);

    UserEntity findByUserName(String userName);

    List<UserEntity> findByUserNameStartingWith(String userName);

    List<UserEntity> findByIdLessThan(Long id);

    Page<UserEntity> findByUserName(String userName, Pageable pageable);



    @Query("select u from UserEntity u where u.id = (select max(p.id) from UserEntity p )")
    UserEntity findMaxIdUser();

    @Query("select u from UserEntity u where u.userName = ?1 and u.email = ?2")
    List<UserEntity> findUserEntityBy1(String userName, String email);

    @Query("select u from UserEntity u where u.userName = :userName and u.email = :email")
    List<UserEntity> findUserEntityBy2(@Param("userName") String userName, @Param("email") String email);

}
