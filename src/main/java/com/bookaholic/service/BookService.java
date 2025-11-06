package com.bookaholic.service;

import com.bookaholic.model.Book;
import com.bookaholic.model.User;import com.bookaholic.repository.BookRepository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService  {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getUserBooks(Long userId, Pageable pageable) {
        return bookRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<Book> getUserBooksBySearch(Long userId, String search, Pageable pageable) {
        return bookRepository.findByUserIdAndSearch(userId, search, pageable);
    }

    @Override
    public Page<Book> getUserBooksByStatus(Long userId, String status, Pageable pageable) {
        return bookRepository.findByUserIdAndReadingStatus(userId, status, pageable);
    }

    @Override
    public Page<Book> getUserBooksByStatusAndSearch(Long userId, String status, String search, Pageable pageable) {
        return bookRepository.findByUserIdAndStatusAndSearch(userId, status, search, pageable);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
    }

    @Override
    public Book saveBook(Book book, User user){
    try {
        book.setUser(user);
        return bookRepository.save(book);
    } catch (Exception e){
      throw new RuntimeException("Book not saved " +  e.getMessage(), e);
    }
}

    @Override
    public void deleteBook(Long bookId) {
      try {
            Book book = getBookById(bookId);
            bookRepository.delete(book);

    } catch (Exception e){
        throw new RuntimeException("Delete failed for book with id" + bookId, e);
    }
}

    @Override
    public Long countUserBooks(Long userId) {
        return bookRepository.countByUserId(userId);
    }

    @Override
    public Long countUserBooksByStatus(Long userId, String status) {
        return bookRepository.countByUserIdAndReadingStatus(userId, status);
    }

    @Override
    public Long countUserBooksBySearch(Long userId, String search) {
        return bookRepository.countByUserIdAndSearch(userId, search);
    }

    @Override
    public Long countUserBooksByStatusAndSearch(Long userId, String status, String search) {
        return bookRepository.countByUserIdAndStatusAndSearch(userId, status, search);
    }
}
