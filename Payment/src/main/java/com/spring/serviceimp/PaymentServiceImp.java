package com.spring.serviceimp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.PaymentDTO;
import com.spring.dto.ReservationDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.Payment;
import com.spring.repo.PaymentRepository;
import com.spring.service.PaymentService;

@Service
public class PaymentServiceImp implements PaymentService {

	    @Autowired
	    private PaymentRepository paymentRepository;

	    @Autowired
	    private RestTemplate restTemplate;

	    // Replace with your actual user service URL
	    private final String userServiceUrl = "http://localhost:8082/users/";
	    private final String reservationUrl = "http://localhost:8083/reservations/{id}";
	    @Override
	    public void doPayment(Long userId, PaymentDTO request) {
	        // Call User Service to get user info
	        ResponseEntity<UserDTO> response = restTemplate.getForEntity(userServiceUrl + userId, UserDTO.class);
	        ResponseEntity<ReservationDTO> response1=restTemplate.getForEntity(reservationUrl, ReservationDTO.class, request.getId());
	        UserDTO userDto = response.getBody();
	        ReservationDTO reserveDto = response1.getBody();
	        if (userDto == null) {
	            throw new RuntimeException("User not found for ID: " + userId);
	        }
	        if (reserveDto == null) {
	            throw new RuntimeException("Reservation not found for ID: " + request.getId());
	        }

	        // You can perform any validation or logic based on user info here
	        // For example, check if user is eligible to make payment, etc.

	        // Create a new Payment entity
	        Payment payment = new Payment();
	        
	        payment.setAmount(request.getAmount());
	        payment.setPaymentStatus("Pending"); // Set to Pending initially; update accordingly later
	        payment.setPaymentMethod(request.getPaymentMethod()); // Card, UPI, Cash, etc.
	        payment.setTransactionId(request.getTransactionId()); // optional or generated
	        payment.setPaymentDate(LocalDateTime.now()); // Set current date and time

	        // Save the payment record
	        paymentRepository.save(payment);
	        System.out.println("Payment has been done for userId"+userId+"for reservation"+request.getId());
	    }

		@Override
		public void cancelPayment(Long paymentId) {
			// TODO Auto-generated method stub
			  Payment payment = paymentRepository.findById(paymentId)
		                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		            
		            // Check if already cancelled or completed (optional)
		            if ("Cancelled".equalsIgnoreCase(payment.getPaymentStatus())) {
		                throw new RuntimeException("Payment is already cancelled.");
		            }
		            if ("Completed".equalsIgnoreCase(payment.getPaymentStatus())) {
		                // Optionally, you may prevent cancellation after completion
		                throw new RuntimeException("Cannot cancel a completed payment.");
		            }

		            // Set status to Cancelled
		            payment.setPaymentStatus("Cancelled");
		            paymentRepository.save(payment);
			
		}
	}