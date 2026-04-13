package com.spring.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String passportNumber;
    // Additional passenger details
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	@Override
	public String toString() {
		return "Passengers [id=" + id + ", name=" + name + ", passportNumber=" + passportNumber + "]";
	}
	public Passengers(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Passengers() {
		super();
		// TODO Auto-generated constructor stub
	}
    

    // constructors, getters, setters...
}