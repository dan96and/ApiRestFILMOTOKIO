package com.example.apirestfilmotokio.controller;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.dto.ReviewDTO;
import com.example.apirestfilmotokio.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ModelMapper modelMapper;

    @Operation(summary = "Create a review for a film")
    @ApiResponse(responseCode = "403", description = "You are not authorized, you need a token")
    @PostMapping("/new-review")
    ResponseEntity<HttpStatus> newReview(@Valid @RequestBody ReviewDTO reviewDTO) {

        reviewService.newReview(convertToEntity(reviewDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "Get the size of a user's review list in a film")
    @ApiResponse(responseCode = "403", description = "You are not authorized, you need a token")
    @GetMapping("/getReviewsSize")
    ResponseEntity<Integer> getReviewsByUserAndFilm(@Valid @RequestParam(name = "userId") Long userId,
                                                    @Valid @RequestParam(name = "filmId") Long filmId) {

        int size = reviewService.getReviewsByUserIDAndFilmId(userId, filmId);

        return ResponseEntity.ok(size);
    }

    @Operation(summary = "Get the reviews of a film")
    @ApiResponse(responseCode = "403", description = "You are not authorized, you need a token")
    @GetMapping("/getReviews")
    ResponseEntity<List<ReviewDTO>> getReviewsByFilmId(@Valid @RequestParam(name = "filmId") Long filmId) {

        List<Review> reviewList = reviewService.getReviewsByFilmId(filmId);

        List<ReviewDTO> reviewDTOList = new ArrayList<>();

        reviewList.forEach(review -> reviewDTOList.add(convertToDTO(review)));

        return ResponseEntity.ok(reviewDTOList);
    }

    Review convertToEntity(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewDTO, Review.class);
    }

    ReviewDTO convertToDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }
}
