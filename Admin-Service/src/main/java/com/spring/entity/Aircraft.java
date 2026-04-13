package com.spring.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long aircraftid;

    private String model;
    private String registrationNumber;
    private int capacity;

    public Aircraft() {}

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
		return "Aircraft [aircraftid=" + aircraftid + ", model=" + model + ", registrationNumber=" + registrationNumber
				+ ", capacity=" + capacity + "]";
	}

	public Aircraft(Long aircraftid, String model, String registrationNumber, int capacity) {
		super();
		this.aircraftid = aircraftid;
		this.model = model;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
	}
    

	
	
   
}