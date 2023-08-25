package com.example.apirestfilmotokio.repository;

import com.example.apirestfilmotokio.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
