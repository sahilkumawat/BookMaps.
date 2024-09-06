package com.maps.book;
import com.maps.book.model.Book;
import com.maps.book.model.BookSearch;
import com.maps.book.repository.BookSearchRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Arrays;

@SpringBootApplication
public class BookMapsApplication {

	@Autowired
	ElasticsearchOperations operations;
	@Autowired
	BookSearchRepository bookSearchRepository;

	@PreDestroy
	public void deleteIndex() {
		operations.indexOps(Book.class).delete();
	}

	@PostConstruct
	public void insertSampleBooks() {

		operations.indexOps(BookSearch.class).refresh();

		// Save data sample

		var documents = Arrays.asList(
				BookSearch.builder().title("Tale of 2 cities").author("Mark Twain").isbn_id(1234452342).
						description("This book is about 2 gothic sister cities Casablanca and Neptune").build(),
				BookSearch.builder().title("Tail of a dragon").author("Jack Dorsey").isbn_id(1234452342).
						description("Story of a dragon who lost its tail in heaven").build(),
				BookSearch.builder().title("Jack loves pasta").author("Tony Birch").isbn_id(1234452342).
						description("A boy named Jack who left his home in pursuit of his dream of becoming a world class Chef").build());

//		bookSearchRepository.saveAll(documents);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMapsApplication.class, args);
		System.out.println("Server is Running");
	}
}
