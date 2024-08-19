package com.pizzaquickserve.controller;

import com.pizzaquickserve.model.Delivery;
import com.pizzaquickserve.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    // Additional endpoints as needed
}
