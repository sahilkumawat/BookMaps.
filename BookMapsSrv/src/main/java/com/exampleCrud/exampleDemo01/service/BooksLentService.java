package com.exampleCrud.exampleDemo01.service;
import com.exampleCrud.exampleDemo01.model.BooksLent;

import java.util.List;

public interface BooksLentService {
    BooksLent saveBooksLent(BooksLent employee);
    List<BooksLent> getAllBooksLent();
    BooksLent getBooksLentById(long id);
    BooksLent updateBooksLent(BooksLent booksLent,long id);
    void deleteBooksLent(long id);
}
