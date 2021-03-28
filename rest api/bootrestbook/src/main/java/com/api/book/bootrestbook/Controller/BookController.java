package com.api.book.bootrestbook.Controller;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//using get function in rest api

@RestController                          //to make controller in rest api we will use this annotation
public class BookController {
    @Autowired                           //to link us to BookService(Fake service)
    private BookService bookService;
    
    //reads all books

    @GetMapping("/books")               //to get all books
    public ResponseEntity<List <Book>> getBooks()                 //ResponseEntity is used to handle error
    {
        List<Book>list = this.bookService.getAllBooks();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();    //build is used to build error 
        }

        return ResponseEntity.of(Optional.of(list));
    }

    //read a particular book with a provided id

    @GetMapping("/books/{id}")          //to get book by id 
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)    //PathVariable helps to read id from our json file
    {
        Book book = bookService.getBookByID(id);
        if(book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //creates a new book

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book)   //RequestBody helps to convert json into java object
    {
        Book b= null;
        try {
            b= this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(b);

        } 
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    //delete a particular book with a given id

    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid) //same concept for pathvariable as above
    {
        
        try {
            this.bookService.deleteBook(bookid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // used to update a record with a given id
    @PutMapping("/books/{bookid}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) //RequestBody helps to convert json into java object and pathvariable is used to get the id 
    {
        try {
            this.bookService.updateBook(book,bookid);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
}
