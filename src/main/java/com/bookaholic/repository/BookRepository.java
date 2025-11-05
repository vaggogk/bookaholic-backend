package com.bookaholic.repository;

import com.bookaholic.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByUserId(Long userId, Pageable pageable);

    Page<Book> findByUserIdAndReadingStatus(Long userId, String readingStatus, Pageable pageable);

    Long countByUserId(Long userId);

    Long countByUserIdAndReadingStatus(Long userId, String readingStatus);

    @Query
    Page<Book> findByUserIdAndSearch(@Param("userId") Long userId,
                                     @Param("search") String search,
                                     Pageable pageable);

    @Query
    Page<Book> findByUserIdAndStatusAndSearch(@Param("userId") Long userId,
                                              @Param("status") String status,
                                              @Param("search") String search,
                                              Pageable pageable);

    @Query
    Long countByUserIdAndSearch(@Param("userId") Long userId,
                                @Param("search") String search);

    @Query
    Long countByUserIdAndStatusAndSearch(@Param("userId") Long userId,
                                         @Param("status") String status,
                                         @Param("search") String search);
}