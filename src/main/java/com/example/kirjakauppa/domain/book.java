package com.example.kirjakauppa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    @Column(name="publishing_year")
    private int year;
    private String isbn;
    private int price;
    
    public book() {}
    
    public book(Long id, String title, String author, int year, String isbn, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
    
    public String gettitle() {
        return title;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getprice() {
        return price;
    }
    
    public void setprice(int price) {
        this.price = price;
    }
    
    public void settitle(String title) {
        this.title = title;
    }
    
    public String getauthor() {
        return author;
    }
    
    public void setauthor(String author) {
        this.author = author;
    }
    
    public int getyear() {
        return year;
    }
    
    public void setyear(int year) {
        this.year = year;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    }