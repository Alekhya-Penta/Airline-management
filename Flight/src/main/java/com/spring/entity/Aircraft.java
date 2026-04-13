package com.spring.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String registrationNumber;
    private int capacity;
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
		return "Aircraft [id=" + id + ", model=" + model + ", registrationNumber=" + registrationNumber + ", capacity="
				+ capacity + "]";
	}
	public Aircraft(Long id, String model, String registrationNumber, int capacity) {
		super();
		this.id = id;
		this.model = model;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
	}
	public Aircraft() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    // Getters & Setters
}