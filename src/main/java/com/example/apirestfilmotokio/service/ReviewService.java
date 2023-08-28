package com.example.apirestfilmotokio.service;

import com.example.apirestfilmotokio.domain.Review;

public interface ReviewService {
    Review newReview(Review review);

    int getReviewsByUserIDAndFilmId(Long userId, Long filmId);
}
