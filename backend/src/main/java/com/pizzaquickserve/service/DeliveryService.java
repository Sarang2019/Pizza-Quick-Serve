package com.pizzaquickserve.service;

import com.pizzaquickserve.model.Delivery;
import com.pizzaquickserve.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    // Additional methods as needed
}
