package com.pizzaquickserve.repository;

import com.pizzaquickserve.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
