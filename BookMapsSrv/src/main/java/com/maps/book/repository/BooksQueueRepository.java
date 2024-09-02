package com.maps.book.repository;

import com.maps.book.model.BooksQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksQueueRepository extends JpaRepository<BooksQueue,Long> {
    //crud
}
