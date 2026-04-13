package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.PaymentDTO;
import com.spring.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping("/pay/{userId}")
    public ResponseEntity<String> doPayment(@PathVariable Long userId, @RequestBody PaymentDTO request) {
        paymentService.doPayment(userId, request);
        return ResponseEntity.ok("Payment process initiated successfully for user ID: " + userId);
    }
    @PostMapping("/cancel/{paymentId}")
    public ResponseEntity<String> cancelPayment(@PathVariable Long paymentId) {
        paymentService.cancelPayment(paymentId);
        return ResponseEntity.ok("Payment with ID " + paymentId + " has been cancelled.");
    }
}