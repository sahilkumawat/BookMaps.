package com.maps.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(indexName = "books")
public class BookSearch {
    private long id;

    private String title;

    private String author;

    private long isbn_id;

    private long user_id;

    private String description;
}
