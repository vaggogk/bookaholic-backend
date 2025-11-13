package com.bookaholic.mapper;

import com.bookaholic.DTO.BookRequestDTO;
import com.bookaholic.DTO.BookResponseDTO;
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


    public BookResponseDTO mapToBookResponseDTO(Book book) {
            BookResponseDTO dto = new BookResponseDTO();
            dto.setId(book.getId());
            dto.setImageUrl(book.getImageUrl());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setPublisher(book.getPublisher());
            dto.setPages(book.getPages());
            dto.setCost(book.getCost());
            dto.setReadingStatus(book.getReadingStatus());
            dto.setReviewRating(book.getReviewRating());
            dto.setNotes(book.getNotes());
            dto.setCreatedAt(book.getCreatedAt());
            dto.setUpdatedAt(book.getUpdatedAt());
            return dto;
    }
}
