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
@Table(name = "follows")
public class Follows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "following",nullable = false)
    private List<String> following_user_id;
    @Column(name = "followers",nullable = false)
    private List<String> followed_user_id;
    @Column(name = "created_at",nullable = false)
    private String created_at;
}
