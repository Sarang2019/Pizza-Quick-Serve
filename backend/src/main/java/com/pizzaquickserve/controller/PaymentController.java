//package com.pizzaquickserve.controller;
//
//import com.pizzaquickserve.service.PaymentService;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/payments")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping("/charge")
//    public ResponseEntity<Charge> chargeCustomer(@RequestParam String token, @RequestParam double amount) {
//        try {
//            Charge charge = paymentService.processPayment(token, amount);
//            return new ResponseEntity<>(charge, HttpStatus.OK);
//        } catch (StripeException e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Handle the exception
//        }
//    }
//}
