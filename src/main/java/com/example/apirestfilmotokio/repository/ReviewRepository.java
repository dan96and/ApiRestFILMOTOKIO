package com.example.apirestfilmotokio.repository;

import com.example.apirestfilmotokio.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT r FROM Review r WHERE r.film.id =:filmId")
    List<Review> getReviewsByFilmId(@Param(value = "filmId") Long filmId);

    @Query(value = "SELECT r FROM Review r WHERE r.user.id =:userId")
    List<Review> getReviewsByUserId(@Param(value = "userId") Long userId);
}
