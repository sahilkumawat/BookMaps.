package com.maps.book;

import com.maps.book.model.BookSearch;
import com.maps.book.repository.BookSearchRepository;
import org.elasticsearch.client.ElasticsearchClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.util.Assert;

@SpringBootTest
class BookMapsApplicationTests {

	@Autowired
	ElasticsearchOperations operations;

	@Test
	void addBooks() {
		operations.save(BookSearch.builder().id(123121).title("Tale of 2 cities").author("Mark Twain").isbn_id(2342242).
				description("Tale of 2 historic cities, casablanca and paris").build());
		operations.save(BookSearch.builder().id(345353).title("Jack loves cheese").author("Mark Zuckerberg").isbn_id(34232).
				description("A story of a boy who wants to grow up to be a world renowned chef").build());
		operations.save(BookSearch.builder().id(657765).title("Who ate my cheese").author("Jack Dorsey").isbn_id(675557).
				description("A mouse lost in Paris who wants to go home").build());
	}

	@Test
	void searchBook() {
		Criteria criteria = new Criteria("description").contains("paris");
		Query query = new CriteriaQuery(criteria);

		SearchHits<BookSearch> book = operations.search(query, BookSearch.class);
		Assert.isTrue(2 == book.getTotalHits(), "Other than 1 books found");
		System.out.println("Book Search Test Passed");
	}

}
