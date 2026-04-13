package com.spring.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Make sure this field exists

    private String status;

    // Add this for passengers
    @OneToMany(cascade = CascadeType.ALL)
    private List<Passengers> passengers;

    // Getter and Setter for passengers
    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Itinerary(Long id, Long userId, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", userId=" + userId + ", status=" + status + "]";
	}

	public Itinerary() {
		super();
		// TODO Auto-generated constructor stub
	}

  

    // getters and setters for other fields
}