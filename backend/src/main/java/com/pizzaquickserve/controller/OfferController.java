package com.pizzaquickserve.controller;

import com.pizzaquickserve.model.Offer;
import com.pizzaquickserve.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.save(offer);
    }

    // Additional endpoints as needed
}
