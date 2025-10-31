package com.bookaholic.repository;

import com.bookaholic.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // find all books by Userid
    List<Book> findByUserId(Long userId);

    //  find all books by reading_status
    List<Book> findByReadingStatus(String readingStatus);

    //  find books by user and status
    List<Book> findByUserIdAndReadingStatus(Long userId, String readingStatus);
}