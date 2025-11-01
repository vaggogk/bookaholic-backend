package com.bookaholic.service;

import com.bookaholic.repository.BookRepository;
import com.bookaholic.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class BookService implements IBookService  {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
         return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long id) {
        return  bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id" + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
