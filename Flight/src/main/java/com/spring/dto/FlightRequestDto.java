package com.spring.dto;

public class FlightRequestDto {
	private Long flightId; // if used
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String status;
    private Long aircraftId;
	public String getSource() {
		return source;
	}
	
	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getAircraftId() {
		return aircraftId;
	}
	public void setAircraftId(Long aircraftId) {
		this.aircraftId = aircraftId;
	}
	public FlightRequestDto(Long flightId, String source, String destination, String departureTime, String arrivalTime, String status, Long aircraftId) {
	    super();
	    this.flightId = flightId; // declare this field if it exists
	    this.source = source;
	    this.destination = destination;
	    this.departureTime = departureTime;
	    this.arrivalTime = arrivalTime;
	    this.status = status;
	    this.aircraftId = aircraftId;
	}
	public FlightRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FlightRequestDto [source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", status=" + status + ", aircraftId=" + aircraftId
				+ "]";
	}
    
}