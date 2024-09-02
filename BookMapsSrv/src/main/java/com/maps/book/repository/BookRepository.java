package com.maps.book.repository;

import com.maps.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    //crud
}
