package com.maps.book.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "body",nullable = false)
    private String body;
    @Column(name = "user_id",nullable = false)
    private long user_id;
    @Column(name = "reviews",nullable = false)
    private List<String> reviews;
    @Column(name = "status",nullable = false)
    private String status;
    @Column(name = "created_at",nullable = false)
    private String created_at;
}
