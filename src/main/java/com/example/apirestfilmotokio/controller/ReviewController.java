package com.example.apirestfilmotokio.controller;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.dto.ReviewDTO;
import com.example.apirestfilmotokio.service.ReviewService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/new-review")
    ResponseEntity<HttpStatus> newReview(@Valid @RequestBody ReviewDTO reviewDTO) {

        reviewService.newReview(convertToEntity(reviewDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/getReviews")
    ResponseEntity<Integer> getReviewsByUserAndFilm(@Valid @RequestParam(name = "userId") Long userId,
                                                    @Valid @RequestParam(name = "filmId") Long filmId) {

        int size = reviewService.getReviewsByUserIDAndFilmId(userId, filmId);

        return ResponseEntity.ok(size);
    }

    Review convertToEntity(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewDTO, Review.class);
    }

    ReviewDTO convertToDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }
}
