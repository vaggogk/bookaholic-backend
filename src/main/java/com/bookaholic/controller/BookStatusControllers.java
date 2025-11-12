package com.bookaholic.controller;

import com.bookaholic.model.Book;
import com.bookaholic.model.User;
import com.bookaholic.service.BookService;
import com.bookaholic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books/status")
public class BookStatusControllers {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    private User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();;
        return userService.findByUsername(username);

    }

    @GetMapping("/currently_reading")
    public ResponseEntity<Page<Book>> getCurrentlyReadingBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books;

        if (search != null && !search.trim().isEmpty()) {

            books = bookService.getUserBooksByStatusAndSearch(user.getId(),"currently_reading", search, pageable);
        } else {

            books = bookService.getUserBooksByStatus(user.getId(),"currently_reading", pageable);
        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("/finished")
    public  ResponseEntity<Page<Book>> getFinishedBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books;

        if (search != null && !search.trim().isEmpty()) {

            books = bookService.getUserBooksByStatusAndSearch(user.getId(), "finished", search, pageable);
        }else {

            books = bookService.getUserBooksByStatus(user.getId(), "finished", pageable);
        }

        return  ResponseEntity.ok(books);
    }


    @GetMapping("/gave_up")
    public ResponseEntity<Page<Book>> getGaveUpBooks (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books;

        if (search != null && !search.trim().isEmpty()) {

            books = bookService.getUserBooksByStatusAndSearch(user.getId(), "gave_up", search, pageable);
        }else {

            books = bookService.getUserBooksByStatus(user.getId(),"gave_up", pageable);
        }
        return ResponseEntity.ok(books);
    }


    @GetMapping("/to_read")
    public ResponseEntity<Page<Book>> getToReadBooks (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books;

        if  (search != null && !search.trim().isEmpty()) {

            books = bookService.getUserBooksByStatusAndSearch(user.getId(), "to_read", search, pageable);

        } else {

            books = bookService.getUserBooksByStatus(user.getId(), "to_read",pageable);
        }

        return ResponseEntity.ok(books);
    }

}
