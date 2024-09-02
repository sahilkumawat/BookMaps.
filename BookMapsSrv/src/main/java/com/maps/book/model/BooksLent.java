package com.maps.book.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books_lent")
public class BooksLent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "lender_id",nullable = false)
    private long lender_id;
    @Column(name = "borrower_id",nullable = false)
    private long borrower_id;
    @Column(name = "book_id",nullable = false)
    private long book_id;
    @Column(name = "lent_at",nullable = false)
    private String lent_at;
    @Column(name = "returned_at",nullable = true)
    private String returned_at;
}
