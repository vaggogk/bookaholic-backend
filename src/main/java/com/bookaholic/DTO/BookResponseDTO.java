package com.bookaholic.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private Double cost;
    private String readingStatus;
    private Double reviewRating;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}