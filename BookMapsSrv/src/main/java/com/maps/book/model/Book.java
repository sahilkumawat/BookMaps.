package com.maps.book.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "# of pages", nullable = false)
    private Integer numPages;
    @Column(name = "isbn_id", nullable = false)
    private long isbn_id;
    @Column(name = "user_id", nullable = false)
    private long user_id;

    @Column(name = "description", nullable = false)
    private String description;

}
