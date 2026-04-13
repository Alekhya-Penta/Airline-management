package com.spring.dto;


public class FlightSummaryDto {
    private Long id;
    private String source;
    private String destination;
    private String departureTime;

    public FlightSummaryDto() {}

    public FlightSummaryDto(Long id, String source, String destination, String departureTime) {
        this.id = id; this.source = source; this.destination = destination; this.departureTime = departureTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
}