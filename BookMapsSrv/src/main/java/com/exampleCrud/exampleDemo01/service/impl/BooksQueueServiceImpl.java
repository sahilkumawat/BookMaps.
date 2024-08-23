package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.BooksQueue;
import com.exampleCrud.exampleDemo01.repository.BooksQueueRepository;
import com.exampleCrud.exampleDemo01.service.BooksQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksQueueServiceImpl implements BooksQueueService {

    @Autowired
    private BooksQueueRepository booksQueueRepository;

    //save booksQueue in database
    @Override
    public BooksQueue saveBooksQueue(BooksQueue booksQueue){
        return booksQueueRepository.save(booksQueue);
    }

    //get all booksQueue form database
    @Override
    public List<BooksQueue> getAllBooksQueue() {
        return booksQueueRepository.findAll();
    }

    //get booksQueue using id
    @Override
    public BooksQueue getBooksQueueById(long id) {
        Optional<BooksQueue> booksQueue =  booksQueueRepository.findById(id);
        if(booksQueue.isPresent()){
            return booksQueue.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update booksQueue
    @Override
    public BooksQueue updateBooksQueue(BooksQueue booksQueue, long id) {
        BooksQueue existingBooksQueue = booksQueueRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingBooksQueue.setBook_id(booksQueue.getBook_id());
        existingBooksQueue.setUser_id(booksQueue.getUser_id());
        existingBooksQueue.setRequested_at(booksQueue.getRequested_at());
        existingBooksQueue.setPosition(booksQueue.getPosition());

        // save
        booksQueueRepository.save(existingBooksQueue);
        return existingBooksQueue;
    }

    //delete booksQueue
    @Override
    public void deleteBooksQueue(long id) {
        //check
        booksQueueRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        booksQueueRepository.deleteById(id);
    }
}
