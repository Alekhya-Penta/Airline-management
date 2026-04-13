package com.spring.dto;

public class ScheduleDTO {
    private Long id;
    private String scheduleTime; // e.g. "2025-12-20T10:00"
    private Long flightId;
    
    
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


	public Long getFlightId() {
		return flightId;
	}


	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	
	@Override
	public String toString() {
		return "ScheduleDTO [id=" + id + ", scheduleTime=" + scheduleTime + ", flightId=" + flightId + "]";
	}
	
	public ScheduleDTO(Long id, String scheduleTime, Long flightId) {
		super();
		this.id = id;
		this.scheduleTime = scheduleTime;
		this.flightId = flightId;
	}
	
	public ScheduleDTO() {
    	
    }

  
}