package com.maps.book.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "# of pages",nullable = false)
    private String numPages;
    @Column(name = "isbn_id",nullable = false)
    private long isbn_id;
    @Column(name = "user_id",nullable = false)
    private long user_id;

    public Map<String, String> convert() {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(getId()));
        map.put("title", getTitle());
        map.put("author", getAuthor());
        map.put("numPages", getNumPages());
        map.put("isbnId", String.valueOf(getIsbn_id()));
        map.put("userId", String.valueOf(getUser_id()));
        return map;
    }

    public static Book convert(Map<String, String> bookMap) {
        return Book.builder()
                .id(Long.parseLong(bookMap.get("id")))
                .title(bookMap.get("title"))
                .author(bookMap.get("author"))
                .numPages(bookMap.get("numPages"))
                .isbn_id(Long.valueOf(bookMap.get("isbnId")))
                .user_id(Long.valueOf(bookMap.get("userId")))
                .build();
    }
}
