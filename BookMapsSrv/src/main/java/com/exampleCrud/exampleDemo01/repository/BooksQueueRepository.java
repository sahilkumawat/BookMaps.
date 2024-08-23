package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.BooksQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksQueueRepository extends JpaRepository<BooksQueue,Long> {
    //crud
}
