package com.maps.book.repository;

import com.maps.book.model.BooksLent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksLentRepository extends JpaRepository<BooksLent,Long> {
    //crud
}
