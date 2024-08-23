package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.Book;
import com.exampleCrud.exampleDemo01.repository.BookRepository;
import com.exampleCrud.exampleDemo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    //save book in database
    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    //get all books form database
    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    //get book using id
    @Override
    public Book getBookbyId(long id) {
        Optional<Book> book =  bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update book
    @Override
    public Book updateBook(Book book, long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setNumPages(book.getNumPages());
        existingBook.setIsbn_id(book.getIsbn_id());
        existingBook.setUser_id(book.getUser_id());
        // save
        bookRepository.save(existingBook);
        return existingBook;
    }

    //delete book
    @Override
    public void deleteBook(long id) {
        //check
        bookRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        bookRepository.deleteById(id);
    }
}
