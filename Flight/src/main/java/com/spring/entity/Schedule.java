package com.spring.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String scheduleTime; // Format: "YYYY-MM-DDTHH:mm"

    @ManyToOne
    private Flight flight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", scheduleTime=" + scheduleTime + ", flight=" + flight + "]";
	}

	public Schedule(Long id, String scheduleTime, Flight flight) {
		super();
		this.id = id;
		this.scheduleTime = scheduleTime;
		this.flight = flight;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    // Getters & Setters
}