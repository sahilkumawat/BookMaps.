package com.maps.book.service;

import com.maps.book.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisService redisService;

    @Test
    public void testGetSet() {
        redisService.addBook(Book.builder().id(123332342l).numPages("233").title("Unit Test").
                user_id(34224l).isbn_id(23424244l).author("Mr Test").build());

        // assert
        Book book = redisService.getBook("123332342");
        Assert.notNull(book, "book can't be null");
        Assert.isTrue(book.getNumPages().equals("233"), "Num Pages doesn't match");
    }
}
