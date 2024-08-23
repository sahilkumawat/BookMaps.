package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.BooksLent;
import com.exampleCrud.exampleDemo01.repository.BooksLentRepository;
import com.exampleCrud.exampleDemo01.service.BooksLentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksLentServiceImpl implements BooksLentService {

    @Autowired
    private BooksLentRepository booksLentRepository;

    //save booksLent in database
    @Override
    public BooksLent saveBooksLent(BooksLent booksLent){
        return booksLentRepository.save(booksLent);
    }

    //get all booksLent from database
    @Override
    public List<BooksLent> getAllBooksLent() {
        return booksLentRepository.findAll();
    }

    //get booksLent using id
    @Override
    public BooksLent getBooksLentById(long id) {
        Optional<BooksLent> booksLent =  booksLentRepository.findById(id);
        if(booksLent.isPresent()){
            return booksLent.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update booksLent
    @Override
    public BooksLent updateBooksLent(BooksLent booksLent, long id) {
        BooksLent existingBooksLent = booksLentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingBooksLent.setLender_id(booksLent.getLender_id());
        existingBooksLent.setBorrower_id(booksLent.getBorrower_id());
        existingBooksLent.setBook_id(booksLent.getBook_id());
        existingBooksLent.setLent_at(booksLent.getLent_at());
        existingBooksLent.setReturned_at(booksLent.getReturned_at());

        // save
        booksLentRepository.save(existingBooksLent);
        return existingBooksLent;
    }

    //delete booksLent
    @Override
    public void deleteBooksLent(long id) {
        //check
        booksLentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        booksLentRepository.deleteById(id);
    }
}
