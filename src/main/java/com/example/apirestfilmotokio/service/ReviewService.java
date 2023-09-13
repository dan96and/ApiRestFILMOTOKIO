package com.example.apirestfilmotokio.service;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.error.exception.DuplicateRecordException;
import com.example.apirestfilmotokio.error.exception.DontFoundRecord;

import java.util.List;

public interface ReviewService {
    Review newReview(Review review) throws DuplicateRecordException;

    List<Review> getReviewsdFilmId(Long filmId);

    List<Review> getReviewsUserId(Long userId) throws DontFoundRecord;
}
