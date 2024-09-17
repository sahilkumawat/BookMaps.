package com.maps.book.model;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
