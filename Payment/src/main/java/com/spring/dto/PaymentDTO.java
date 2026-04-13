package com.spring.dto;

public class PaymentDTO {
		private Long id;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		private Double amount;
	    private String paymentMethod; // Card, UPI, Cash
	    private String transactionId; // optional
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
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
		@Override
		public String toString() {
			return "PaymentDTO [id=" + id + ", amount=" + amount + ", paymentMethod=" + paymentMethod
					+ ", transactionId=" + transactionId + "]";
		}
		public PaymentDTO(Double amount, String paymentMethod, String transactionId) {
			super();
			this.amount = amount;
			this.paymentMethod = paymentMethod;
			this.transactionId = transactionId;
		}
		public PaymentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}