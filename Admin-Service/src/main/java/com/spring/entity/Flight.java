package com.spring.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String status; // e.g., "Scheduled", "Cancelled"
  

    

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aircraftid")
    private Aircraft aircraft;

    public Flight() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Aircraft getAircraft() { return aircraft; }
    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }

	public Flight(Long id, String source, String destination, String departureTime, String arrivalTime, String status,
			Aircraft aircraft) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		this.aircraft = aircraft;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", status=" + status + ", aircraft=" + aircraft
				+ "]";
	}
    
    
}