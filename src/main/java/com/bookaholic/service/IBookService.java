package com.bookaholic.service;

import com.bookaholic.DTO.BookRequestDTO;
import com.bookaholic.model.Book;
import com.bookaholic.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public interface IBookService {

    public Page<Book> getUserBooks(Long userId, Pageable pageable);

    public  Page<Book> getUserBooksBySearch(Long userId, String search, Pageable pageable);

    public Page<Book> getUserBooksByStatus(Long userId, String status, Pageable pageable);

    public Page<Book> getUserBooksByStatusAndSearch(Long userId, String status, String search, Pageable pageable);

    public Book getBookById(Long BookId);

    public Book saveBook(BookRequestDTO bookDTO, User user);

    public Book updateBook(Long bookId, BookRequestDTO updatedBook, User user);

    public void deleteBook(Long bookId);

    public Long countUserBooks(Long userId);

    public Long countUserBooksByStatus (Long userId, String status);

    public Long countUserBooksBySearch(Long userId, String search);

    public Long countUserBooksByStatusAndSearch(Long userId, String status, String search);
}
