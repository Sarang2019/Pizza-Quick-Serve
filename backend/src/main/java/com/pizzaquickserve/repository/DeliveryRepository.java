package com.pizzaquickserve.repository;

import com.pizzaquickserve.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
