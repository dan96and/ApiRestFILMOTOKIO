package com.example.apirestfilmotokio.service;

import com.example.apirestfilmotokio.domain.Review;

import java.util.List;

public interface ReviewService {
    Review newReview(Review review);

    int getReviewsByUserIDAndFilmId(Long userId, Long filmId);

    List<Review> getReviewsByFilmId(Long filmId);
}
