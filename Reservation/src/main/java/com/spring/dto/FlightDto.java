package com.spring.dto;


public class FlightDto {
    private Long id;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String status;
    private String aircraftModel; // Optional: include aircraft info if needed

 
    public Long getId() {
        return id;
    }

    
    public FlightDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FlightDto(Long id, String source, String destination, String departureTime, String arrivalTime,
			String status, String aircraftModel) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		this.aircraftModel = aircraftModel;
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

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }
}