package com.bookaholic.mapper;

import com.bookaholic.DTO.BookRequestDTO;
import com.bookaholic.model.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class BookMapper {

    public Book mapToBookEntity(BookRequestDTO dto) {
        Book book = new Book();
        book.setImageUrl(dto.getImageUrl());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setPages(dto.getPages());
        book.setCost(dto.getCost());
        book.setReadingStatus(dto.getReadingStatus());
        book.setReviewRating(dto.getReviewRating());
        book.setNotes(dto.getNotes());
        return book;
    }


    public BookRequestDTO mapToBookResponseDTO(Book book) {
           return new BookRequestDTO(
                   book.getId(),
                   book.getImageUrl(),
                   book.getTitle(),
                   book.getAuthor(),
                   book.getPublisher(),
                   book.getPages(),
                   book.getCost(),
                   book.getReadingStatus(),
                   book.getReviewRating(),
                   book.getNotes(),
                   book.getCreatedAt(),
                   book.getUpdatedAt()
           );
    }
}
