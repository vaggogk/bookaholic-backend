package com.bookaholic.DTO;

import com.bookaholic.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDTO {

    private Long id;

    private String imageUrl;

    @NotBlank(message = "Book title is required")
    @Size(min = 1, max = 100, message = "Book title must be between 1-100 characters.")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 1, max = 100, message = "Author must be between 1-100 characters.")
    private String author;

    @NotBlank(message = "Publisher is required")
    @Size(min = 1, max = 100, message = "Publisher must be between 1-100 characters.")
    private String publisher;

    @NotBlank(message = "Pages is required")
    @Min(value = 0,  message = "Pages can be 0" )
    @Max(value = 10000, message = "Pages cannot exceed 10,000")
    private int pages;

    @DecimalMin(value = "0.0" , message = "Cost is required")
    private Double cost;

    @NotBlank(message = "Reading status required")
    @Pattern(regexp = "to_read|currently_reading|finished|gave_up",
            message = "Reading status can be to_read or currently_reading or finished or gave_up")
    private String readingStatus;

    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value = "5.0", message = "Rating cannot exceed 5")
    private Double reviewRating;

    @Size(max = 10000, message = "Notes cannot exceed 10.000 characters")
    private String notes;

    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
}
