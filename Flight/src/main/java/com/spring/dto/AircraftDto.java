package com.spring.dto;

public class AircraftDto {
    private Long id;
    private String model;
    private String registrationNumber;
    private int capacity;

    public AircraftDto() {}
    public AircraftDto(Long id, String model, String registrationNumber, int capacity) {
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "AircraftDto [id=" + id + ", model=" + model + ", registrationNumber=" + registrationNumber
				+ ", capacity=" + capacity + "]";
	}

    
}