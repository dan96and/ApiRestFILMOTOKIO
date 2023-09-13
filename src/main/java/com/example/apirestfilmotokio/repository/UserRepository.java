package com.example.apirestfilmotokio.repository;

import com.example.apirestfilmotokio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query(value = "SELECT u FROM User u WHERE u.id =:userId")
    User existsByUserId(@Param("userId") Long userId);
}