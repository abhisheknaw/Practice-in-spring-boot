package com.api.book.bootrestbook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*this our class that defines how our book will look like it will have parameterised constructor,
default construtor ,getter setter function, tostring function*/

@Entity   
@Table(name = "books")                                  //to make our class as entity for database
public class Book {
    @Id                                                     //to make our id as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)         //to auto increment our id value
    private int id;
    private String title; 
    
    @OneToOne(cascade = CascadeType.ALL)              //to link book to author in unidirectional relationship
    @JsonManagedReference                             //to avoid let going our data to infinte loop of book and author 
    private Author author;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public Book() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "books [author=" + author + ", id=" + id + ", title=" + title + "]";
    }

    
    
}
