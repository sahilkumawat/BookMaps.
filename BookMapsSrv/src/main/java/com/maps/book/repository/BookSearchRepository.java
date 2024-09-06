package com.maps.book.repository;

import com.maps.book.model.BookSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookSearchRepository extends ElasticsearchRepository<BookSearch, Long> {

}
