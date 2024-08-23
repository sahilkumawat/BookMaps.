package com.exampleCrud.exampleDemo01.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "booksLent")
public class BooksLent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "lender_id",nullable = false)
    private String lender_id;
    @Column(name = "borrower_id",nullable = false)
    private String borrower_id;
    @Column(name = "book_id",nullable = false)
    private String book_id;
    @Column(name = "lent_at",nullable = false)
    private String lent_at;
    @Column(name = "returned_at",nullable = false)
    private String returned_at;
}
