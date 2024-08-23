package com.exampleCrud.exampleDemo01.controller;
import com.exampleCrud.exampleDemo01.model.Book;
import com.exampleCrud.exampleDemo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Book> getAllEmployee(){
        return bookService.getAllBook();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/books/1
    public ResponseEntity<Book> getBookbyId(@PathVariable("id") long bookID){
        return new ResponseEntity<Book>(bookService.getBookbyId(bookID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id,
                                                   @RequestBody Book book){
        return new ResponseEntity<Book>(bookService.updateBook(book,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from db
        bookService.deleteBook(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

}
