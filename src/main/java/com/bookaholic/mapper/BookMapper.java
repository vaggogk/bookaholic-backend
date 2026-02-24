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
        book.setCoverImage(dto.getCoverImage());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setPages(dto.getPages());
        book.setCost(dto.getCost());
        book.setReadingStatus(dto.getReadingStatus());
        book.setReviewRating(dto.getReviewRating());
        book.setStarted(dto.getStarted());
        book.setFinished(dto.getFinished());
        book.setNotes(dto.getNotes());
        return book;
    }


    public BookResponseDTO mapToBookResponseDTO(Book book) {
            BookResponseDTO dto = new BookResponseDTO();
            dto.setId(book.getId());
            dto.setCoverImage(book.getCoverImage());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setPublisher(book.getPublisher());
            dto.setPages(book.getPages());
            dto.setCost(book.getCost());
            dto.setReadingStatus(book.getReadingStatus());
            dto.setReviewRating(book.getReviewRating());
            dto.setStarted(book.getStarted());
            dto.setFinished(book.getFinished());
            dto.setNotes(book.getNotes());
            dto.setCreatedAt(book.getCreatedAt());
            dto.setUpdatedAt(book.getUpdatedAt());
            return dto;
    }
}
