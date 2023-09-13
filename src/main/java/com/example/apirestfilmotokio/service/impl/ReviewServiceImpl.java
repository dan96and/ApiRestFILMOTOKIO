package com.example.apirestfilmotokio.service.impl;

import com.example.apirestfilmotokio.domain.Review;
import com.example.apirestfilmotokio.domain.User;
import com.example.apirestfilmotokio.error.exception.DontFoundRecord;
import com.example.apirestfilmotokio.error.exception.DuplicateRecordException;
import com.example.apirestfilmotokio.repository.ReviewRepository;
import com.example.apirestfilmotokio.repository.UserRepository;
import com.example.apirestfilmotokio.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Review newReview(Review review) throws DuplicateRecordException {

        Long idUser = review.getUser().getId();

        List<Review> reviews = reviewRepository.getReviewsByFilmId(review.getFilm().getId());

        List<Review> listReviewFilter = reviews.stream()
                .filter(reviewFilter -> reviewFilter.getUser().getId().equals(idUser)).toList();

        if (listReviewFilter.isEmpty()) {
            reviewRepository.save(review);
            return review;
        } else {
            throw new DuplicateRecordException("The user has already created a review on the film");
        }
    }

    @Override
    public List<Review> getReviewsdFilmId(Long filmId) {

        return reviewRepository.getReviewsByFilmId(filmId);
    }

    @Override
    public List<Review> getReviewsUserId(Long userId) throws DontFoundRecord {

        User user = userRepository.existsByUserId(userId);

        if (user == null) {
            throw new DontFoundRecord("The user dont exist");
        }

        return reviewRepository.getReviewsByUserId(userId);
    }
}

