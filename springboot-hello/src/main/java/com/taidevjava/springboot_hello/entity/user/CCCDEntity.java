package com.taidevjava.springboot_hello.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "java_cccd")
@DynamicInsert
@DynamicUpdate
public class CCCDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cccdId", nullable = false)
    Long id;

    @Column(length = 50, nullable = false)
    String cccdName;
}
