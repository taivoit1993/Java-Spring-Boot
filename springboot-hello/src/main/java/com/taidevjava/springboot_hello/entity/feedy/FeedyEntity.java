package com.taidevjava.springboot_hello.entity.feedy;

import com.taidevjava.springboot_hello.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "java_feedy")
@DynamicInsert
@DynamicUpdate
public class FeedyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedId")
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'feedy title'", nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)    //foreign key of FeefyEntity
    private UserEntity user;

}
