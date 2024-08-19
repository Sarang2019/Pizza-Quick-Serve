//package com.pizzaquickserve.service;
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PaymentService {
//
//    @Value("${stripe.api.key}") // Inject your Stripe API key from application.properties
//    private String stripeApiKey;
//
//    public Charge processPayment(String token, double amount) throws StripeException {
//        // Initialize Stripe with the API key
//        Stripe.apiKey = stripeApiKey;
//
//        // Convert the amount to cents (Stripe processes amounts in cents)
//        Map<String, Object> chargeParams = new HashMap<>();
//        chargeParams.put("amount", (int) (amount * 100)); // Amount in cents
//        chargeParams.put("currency", "usd");
//        chargeParams.put("source", token); // The Stripe token generated on the frontend
//        chargeParams.put("description", "Pizza Quick Serve Payment");
//
//        // Create a charge using Stripe's API
//        return Charge.create(chargeParams);
//    }
//}
