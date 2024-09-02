package com.maps.book.controller;
import com.maps.book.model.BooksQueue;
import com.maps.book.service.BooksQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/booksQueue")
public class BooksQueueController {
    @Autowired
    private BooksQueueService booksQueueService;

    @PostMapping
    public ResponseEntity<BooksQueue> saveBooksQueue(@RequestBody BooksQueue booksQueue){
        return new ResponseEntity<BooksQueue>(booksQueueService.saveBooksQueue(booksQueue), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<BooksQueue> getAllBooksQueue(){
        return booksQueueService.getAllBooksQueue();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<BooksQueue> getBooksQueueById(@PathVariable("id") long bookID){
        return new ResponseEntity<BooksQueue>(booksQueueService.getBooksQueueById(bookID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<BooksQueue> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody BooksQueue booksQueue){
        return new ResponseEntity<BooksQueue>(booksQueueService.updateBooksQueue(booksQueue,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete bookQueue from db
        booksQueueService.deleteBooksQueue(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

}
