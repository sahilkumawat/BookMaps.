package com.maps.book.service;
import com.maps.book.model.BooksQueue;

import java.util.List;

public interface BooksQueueService {
    BooksQueue saveBooksQueue(BooksQueue booksQueue);
    List<BooksQueue> getAllBooksQueue();
    BooksQueue getBooksQueueById(long id);
    BooksQueue updateBooksQueue(BooksQueue employee,long id);
    void deleteBooksQueue(long id);
}
