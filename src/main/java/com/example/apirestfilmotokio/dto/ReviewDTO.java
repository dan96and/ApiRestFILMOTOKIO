package com.example.apirestfilmotokio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String title;

    @NotBlank
    @Size(min = 1, max = 255)
    private String textReview;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long userId;

    @NotNull
    private Long filmId;
}
