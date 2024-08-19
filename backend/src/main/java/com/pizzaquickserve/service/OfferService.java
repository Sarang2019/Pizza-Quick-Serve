package com.pizzaquickserve.service;

import com.pizzaquickserve.model.Offer;
import com.pizzaquickserve.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    // Additional methods as needed
}
