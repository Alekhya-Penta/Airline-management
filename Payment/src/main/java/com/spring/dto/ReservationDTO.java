package com.spring.dto;

public class ReservationDTO {
	private Long id;
    private Long userId;
    private Long flightId;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", userId=" + userId + ", flightId=" + flightId + ", status=" + status
				+ "]";
	}
	public ReservationDTO(Long id, Long userId, Long flightId, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.status = status;
	}
	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
