package com.maps.book;

import com.maps.book.model.Book;

import org.junit.jupiter.api.Test;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookSearchTest {

    @Autowired
    ElasticsearchOperations operations;


    @Test
    void textSearch() throws ParseException {
        var expectedWord = "Jack";
        var query = new CriteriaQuery(
                new Criteria("keywords").contains(expectedWord));

        var result = operations.search(query, Book.class);

        assertThat(result).isNotNull();

        for (var book : result) {
            assertThat(book.getContent().getDescription()).contains(expectedWord);
        }
    }
}
