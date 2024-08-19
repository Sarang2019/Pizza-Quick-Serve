package com.pizzaquickserve.repository;

import com.pizzaquickserve.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
