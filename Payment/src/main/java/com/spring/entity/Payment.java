package com.spring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Double amount;
    private String paymentStatus; // e.g., Pending, Completed
    private String paymentMethod; // e.g., Card, UPI, Cash
    private String transactionId;
    private LocalDateTime paymentDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentStatus="
				+ paymentStatus + ", paymentMethod=" + paymentMethod + ", transactionId=" + transactionId
				+ ", paymentDate=" + paymentDate + "]";
	}
	public Payment(Long id, Long reservationId, Double amount, String paymentStatus, String paymentMethod,
			String transactionId, LocalDateTime paymentDate) {
		super();
		this.id = id;
		
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.paymentDate = paymentDate;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	} 
}