package com.maps.book.service;
import com.maps.book.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBook();
    Book getBookbyId(long id);
    Book updateBook(Book book,long id);
    void deleteBook(long id);
}
