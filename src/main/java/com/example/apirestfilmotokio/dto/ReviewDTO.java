package com.example.apirestfilmotokio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String title;

    @NotBlank
    private String textReview;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long userId;

    @NotNull
    private Long filmId;
}
