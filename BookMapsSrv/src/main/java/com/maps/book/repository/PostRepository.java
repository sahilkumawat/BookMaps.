package com.maps.book.repository;

import com.maps.book.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    //crud
}
