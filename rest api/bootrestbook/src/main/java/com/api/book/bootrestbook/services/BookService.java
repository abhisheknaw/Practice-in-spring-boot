package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//fake service for database beacasue we are not using jpa dependecy
@Component            //this will tell spring this we have to use its object when autowiring is done 
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    //used when we were not using jpa
    // private static List<Book> list= new ArrayList<>();

    // static{
    //     list.add(new Book(1,"Learning In JAVA","XYZ"));
    //     list.add(new Book(2,"Think JAVA","ABC"));                
    //     list.add(new Book(3,"Advance JAVA","LMN"));         
    // }
    
    //get all books
    public List<Book> getAllBooks()
    {
        List<Book> list = (List<Book>)this.bookRepository.findAll();    //when we are using jpa
        return list;                                                       
        //used when we were not using jpa
        //return list;   
    }
    //get book by id
    public Book getBookByID(int id)
    {
        Book book = null;
        try {  
            //used when we were not using jpa                                                              
            //book = list.stream().filter(e->e.getId()==id).findFirst().get(); //stream function to read our list
            book = this.bookRepository.findById(id);           //when we are using jpa
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return book;
    }

    //creating a new book

    public Book addBook(Book book)
    {
        Book b = this.bookRepository.save(book);      //when we are using jpa
        return b;
        //used wehen we were not using jpa
        //list.add(book);
        //return book; 
    }

    //deleting a book with given id

    public void deleteBook(int bid)
    {
        this.bookRepository.deleteById(bid);  //when we are using jpa
        //used when we were not using jpa
        //list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList()); //here what we are doing is that we are filtering on the basis that if our bid != book.id then we will push that book in our list using collector function
    }

    //updating a book with the use of bookid

    public void updateBook(Book book, int bookid)
    {
        book.setId(bookid);                           // when we are using jpa
        this.bookRepository.save(book);
        //used when we were not using jpa
        // list = list.stream().map(b->{                      //map function is used to search for each element
        //     if(b.getId() == bookid)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;                                    //here we are returning b to list whether it is updated or not
        // }).collect(Collectors.toList());
    }
}
