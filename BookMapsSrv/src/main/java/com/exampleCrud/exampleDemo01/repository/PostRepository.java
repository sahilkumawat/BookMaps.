package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    //crud
}
