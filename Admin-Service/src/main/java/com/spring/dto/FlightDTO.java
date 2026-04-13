package com.spring.dto;

public class FlightDTO {
    private Long id;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String status;
    private Long aircraftId;

    public FlightDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
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

	@Override
	public String toString() {
		return "FlightDTO [id=" + id + ", source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", status=" + status + ", aircraftId=" + aircraftId
				+ "]";
	}

	public FlightDTO(Long id, String source, String destination, String departureTime, String arrivalTime,
			String status, Long aircraftId) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		this.aircraftId = aircraftId;
	}

    
}