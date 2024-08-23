package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    //crud
}
