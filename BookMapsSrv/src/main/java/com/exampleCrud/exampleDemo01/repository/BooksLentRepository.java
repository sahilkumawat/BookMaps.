package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.BooksLent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksLentRepository extends JpaRepository<BooksLent,Long> {
    //crud
}
