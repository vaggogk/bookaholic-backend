package com.bookaholic.controller;

import com.bookaholic.mapper.BookMapper;
import com.bookaholic.model.User;
import com.bookaholic.service.BookService;
import com.bookaholic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books/")
public class CountController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookMapper bookMapper;

    private User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        return userService.findByUsername(username);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getBookCount(
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Long count;

        if (search != null && !search.trim().isEmpty()) {
            count = bookService.countUserBooksBySearch(user.getId(), search);
        } else {
            count = bookService.countUserBooks(user.getId());
        }

        return ResponseEntity.ok(count);
    }

    @GetMapping("/currently_reading/count")
    public ResponseEntity<Long> getCurrentlyReadingCount(
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Long count;

        if (search != null && !search.trim().isEmpty()) {
            count = bookService.countUserBooksByStatusAndSearch(user.getId(), "currently_reading", search);
        } else {
            count = bookService.countUserBooksByStatus(user.getId(), "currently_reading");
        }
        return ResponseEntity.ok(count);
    }

    @GetMapping("/finished/count")
    public  ResponseEntity<Long> getFinishedCount(
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Long count;

        if (search != null && !search.trim().isEmpty()) {
            count = bookService.countUserBooksByStatusAndSearch(user.getId(),"finished",search);
        }else {
            count= bookService.countUserBooksByStatus(user.getId(), "finished");
        }
        return ResponseEntity.ok(count);
    }

    @GetMapping("/gave_up/count")
    public ResponseEntity<Long> getGaveUpCount (
            @RequestParam(required = false) String search,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Long count;

        if (search != null && !search.trim().isEmpty()) {
            count = bookService.countUserBooksByStatusAndSearch(user.getId(),"gave_up",search);
        } else {
            count = bookService.countUserBooksByStatus(user.getId(), "gave_up");
        }
        return ResponseEntity.ok(count);
    }
    @GetMapping("/to_read/count")
     public ResponseEntity<Long> getToReadCount (
        @RequestParam(required = false) String search,
        Authentication authentication) {

    User user = getCurrentUser(authentication);
    Long count;

    if (search != null && !search.trim().isEmpty()) {
        count = bookService.countUserBooksByStatusAndSearch(user.getId(),"to_read", search);
    } else {
        count = bookService.countUserBooksByStatus(user.getId(), "to_read");
    }
    return ResponseEntity.ok(count);
}

}
