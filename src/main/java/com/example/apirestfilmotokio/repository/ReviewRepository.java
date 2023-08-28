package com.example.apirestfilmotokio.repository;

import com.example.apirestfilmotokio.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query (value = "SELECT COUNT (r.id) FROM Review r WHERE r.user.id =:userId AND r.film.id=:filmId")
    int getByUserAndFilm(@Param(value = "userId") Long userId, @Param(value = "filmId") Long filmId);
}
