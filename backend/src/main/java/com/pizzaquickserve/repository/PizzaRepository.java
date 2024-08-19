package com.pizzaquickserve.repository;

import com.pizzaquickserve.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
