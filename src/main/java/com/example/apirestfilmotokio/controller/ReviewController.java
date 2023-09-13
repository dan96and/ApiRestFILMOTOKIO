package com.example.apirestfilmotokio.controller;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.dto.ReviewDTO;
import com.example.apirestfilmotokio.error.exception.DontFoundRecord;
import com.example.apirestfilmotokio.error.exception.DuplicateRecordException;
import com.example.apirestfilmotokio.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "You are not authorized, you need a token"),
            @ApiResponse(responseCode = "409", description = "The user has already created a review on the film")})
    @PostMapping("/new-review")
    ResponseEntity<HttpStatus> newReview(@Valid @RequestBody ReviewDTO reviewDTO) throws DuplicateRecordException {

        reviewService.newReview(convertToEntity(reviewDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "Get the reviews of a film")
    @ApiResponse(responseCode = "403", description = "You are not authorized, you need a token")
    @GetMapping("/getReviews")
    ResponseEntity<List<ReviewDTO>> getReviewsByFilmId(@Valid @RequestParam(name = "filmId") Long filmId) {

        List<Review> reviewList = reviewService.getReviewsdFilmId(filmId);

        List<ReviewDTO> reviewDTOList = new ArrayList<>();

        reviewList.forEach(review -> reviewDTOList.add(convertToDTO(review)));

        return ResponseEntity.ok(reviewDTOList);
    }

    @Operation(summary = "Get the reviews by user")
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "You are not authorized, you need a token"),
            @ApiResponse(responseCode = "404", description = "The user dont exist")})
    @GetMapping("/getReviews/{idUser}")
    ResponseEntity<List<ReviewDTO>> getReviewsByUserId(@PathVariable Long idUser) throws DontFoundRecord {

        List<Review> reviewList = reviewService.getReviewsUserId(idUser);

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
