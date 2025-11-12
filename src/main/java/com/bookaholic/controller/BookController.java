package com.bookaholic.controller;

import com.bookaholic.DTO.BookRequestDTO;
import com.bookaholic.DTO.BookResponseDTO;
import com.bookaholic.mapper.BookMapper;
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
@RequestMapping("/api/books")
public class BookController {

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

    @GetMapping
    public ResponseEntity<Page<BookResponseDTO>> getUserBooks(

              @RequestParam(defaultValue = "0") int page,
              @RequestParam(defaultValue = "10") int size,
              @RequestParam(required = false) String search,
              Authentication authentication) {

        User user = getCurrentUser(authentication);
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books;

        if (search != null && !search.trim().isEmpty()) {
            books = bookService.getUserBooksBySearch(user.getId(), search, pageable);
        } else {
            books = bookService.getUserBooks(user.getId(), pageable);
        }


        Page<BookResponseDTO> responseDTOs = books.map(bookMapper::mapToBookResponseDTO);
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(

                    @PathVariable Long id,
                     Authentication authentication) {

        User user = getCurrentUser(authentication);
        Book book = bookService.getBookById(id);


        if (!book.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }


        BookResponseDTO responseDTO = bookMapper.mapToBookResponseDTO(book);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(
                 @RequestBody BookRequestDTO bookDTO,
                 Authentication authentication) {

        User user = getCurrentUser(authentication);
        Book savedBook = bookService.saveBook(bookDTO, user);


        BookResponseDTO responseDTO = bookMapper.mapToBookResponseDTO(savedBook);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(
                 @PathVariable Long id,
                 @RequestBody BookRequestDTO bookDTO,
                 Authentication authentication) {

        User user = getCurrentUser(authentication);


        Book existingBook = bookService.getBookById(id);
        if (!existingBook.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        Book updatedBook = bookService.updateBook(id, bookDTO, user);
        BookResponseDTO responseDTO = bookMapper.mapToBookResponseDTO(updatedBook);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id,
            Authentication authentication) {

        User user = getCurrentUser(authentication);
        Book book = bookService.getBookById(id);

        if (!book.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}