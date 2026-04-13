package com.spring.dto;

import com.spring.entity.Aircraft;

public class AircraftDTO {
    private Long aircraftid;
    private String model;
    private String registrationNumber;
    private int capacity;

    public AircraftDTO() {}

    public AircraftDTO(Aircraft aircraft) {
        this.aircraftid = aircraft.getAircraftid();
        this.model = aircraft.getModel();
        this.registrationNumber = aircraft.getRegistrationNumber();
        this.capacity = aircraft.getCapacity();
    }

	public Long getAircraftid() {
		return aircraftid;
	}

	public void setAircraftid(Long aircraftid) {
		this.aircraftid = aircraftid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "AircraftDTO [aircraftid=" + aircraftid + ", model=" + model + ", registrationNumber="
				+ registrationNumber + ", capacity=" + capacity + "]";
	}

	public AircraftDTO(Long aircraftid, String model, String registrationNumber, int capacity) {
		super();
		this.aircraftid = aircraftid;
		this.model = model;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
	}
    
    
}