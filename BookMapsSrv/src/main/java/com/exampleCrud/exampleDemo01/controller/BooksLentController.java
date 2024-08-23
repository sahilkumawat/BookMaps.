package com.exampleCrud.exampleDemo01.controller;
import com.exampleCrud.exampleDemo01.model.BooksLent;
import com.exampleCrud.exampleDemo01.service.BooksLentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/booksLent")
public class BooksLentController {

    @Autowired
    private BooksLentService booksLentService;

    @PostMapping
    public ResponseEntity<BooksLent> saveBooksLent(@RequestBody BooksLent booksLent){
        return new ResponseEntity<BooksLent>(booksLentService.saveBooksLent(booksLent), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<BooksLent> getAllBooksLent(){
        return booksLentService.getAllBooksLent();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<BooksLent> getBooksLentById(@PathVariable("id") long booksLent_ID){
        return new ResponseEntity<BooksLent>(booksLentService.getBooksLentById(booksLent_ID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<BooksLent> updateBooksLent(@PathVariable("id") long id,
                                                   @RequestBody BooksLent booksLent){
        return new ResponseEntity<BooksLent>(booksLentService.updateBooksLent(booksLent,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from db
        booksLentService.deleteBooksLent(id);
        return new ResponseEntity<String>("booksLent deleted Successfully.",HttpStatus.OK);
    }

}
