package com.example.apirestfilmotokio.controller;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.dto.ReviewDTO;
import com.example.apirestfilmotokio.service.ReviewService;
import com.example.apirestfilmotokio.util.ResponseUtil;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/new-review")
    ResponseEntity<ResponseUtil> newReview(@Valid @RequestBody ReviewDTO reviewDTO) {

        reviewService.newReview(convertToEntity(reviewDTO));

        return new ResponseEntity<>(ResponseUtil.builder().message("Correct response").errorCode(ResponseUtil.NO_ERROR).build(), HttpStatus.OK);
    }

    Review convertToEntity(ReviewDTO reviewDTO) {
        return modelMapper.map(reviewDTO, Review.class);
    }

    ReviewDTO convertToDTO(Review review) {
        return modelMapper.map(review, ReviewDTO.class);
    }
}
