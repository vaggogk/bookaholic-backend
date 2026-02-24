package com.bookaholic.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDTO {
    private Long id;
    private String coverImage;
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private Double cost;
    private String readingStatus;
    private Double reviewRating;
    private Date started;
    private Date finished;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}