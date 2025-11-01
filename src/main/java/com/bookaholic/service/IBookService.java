package com.bookaholic.service;

import com.bookaholic.model.Book;
import com.bookaholic.repository.BookRepository;
import java.util.List;

public interface IBookService {

    public  Book saveBook(Book book);

    public Book findBookById(Long id);

    public List<Book> getAllBooks();

     public void  deleteBook(Long id);
}
