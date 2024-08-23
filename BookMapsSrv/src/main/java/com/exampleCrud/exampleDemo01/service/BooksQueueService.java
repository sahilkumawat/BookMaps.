package com.exampleCrud.exampleDemo01.service;
import com.exampleCrud.exampleDemo01.model.BooksQueue;

import java.util.List;

public interface BooksQueueService {
    BooksQueue saveBooksQueue(BooksQueue booksQueue);
    List<BooksQueue> getAllBooksQueue();
    BooksQueue getBooksQueueById(long id);
    BooksQueue updateBooksQueue(BooksQueue employee,long id);
    void deleteBooksQueue(long id);
}
