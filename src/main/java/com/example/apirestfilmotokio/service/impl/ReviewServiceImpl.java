package com.example.apirestfilmotokio.service.impl;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.repository.ReviewRepository;
import com.example.apirestfilmotokio.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review newReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Override
    public int getReviewsByUserIDAndFilmId(Long userId, Long filmId) {

        return reviewRepository.getByUserAndFilm(userId, filmId);
    }

    @Override
    public List<Review> getReviewsByFilmId(Long filmId) {
        return reviewRepository.getReviewsByFilmId(filmId);
    }
}

