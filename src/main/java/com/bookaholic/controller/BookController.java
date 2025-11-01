package com.bookaholic.controller;

import com.bookaholic.model.Book;
import com.bookaholic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //  CREATE BOOK
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    //  GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // DELETE
}