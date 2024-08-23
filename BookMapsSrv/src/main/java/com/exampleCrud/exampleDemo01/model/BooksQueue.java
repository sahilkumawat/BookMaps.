package com.exampleCrud.exampleDemo01.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "booksQueue")
public class BooksQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_id",nullable = false)
    private String book_id;
    @Column(name = "user_id",nullable = false)
    private String user_id;
    @Column(name = "requested_at",nullable = false)
    private String requested_at;
    @Column(name = "position",nullable = false)
    private int position;
}
