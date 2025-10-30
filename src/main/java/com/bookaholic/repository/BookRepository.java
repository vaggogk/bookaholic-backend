package com.bookaholic.repository;

import com.bookaholic.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // 📚 Βρες όλα τα βιβλία ενός user
    List<Book> findByUserId(Long userId);

    // 🏷️ Βρες βιβλία by reading status
    List<Book> findByReadingStatus(String readingStatus);

    // 🔍 Βρες βιβλία ενός user by status
    List<Book> findByUserIdAndReadingStatus(Long userId, String readingStatus);
}