package com.spring.service;

import com.spring.dto.PaymentDTO;

public interface PaymentService {
    void doPayment(Long userId, PaymentDTO request);
    void cancelPayment(Long paymentId);
}