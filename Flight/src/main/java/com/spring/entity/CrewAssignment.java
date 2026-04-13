package com.spring.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "CrewAssignment")
public class CrewAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crew_member_id")
    private CrewMember crewMember;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight; // your existing Flight entity

    private String assignmentType; // e.g., Pilot, Flight Attendant

    // Constructors
    public CrewAssignment() {}
    public CrewAssignment(CrewMember crewMember, Flight flight, String assignmentType) {
        this.crewMember = crewMember;
        this.flight = flight;
        this.assignmentType = assignmentType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public CrewMember getCrewMember() {
        return crewMember;
    }
    public void setCrewMember(CrewMember crewMember) {
        this.crewMember = crewMember;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public String getAssignmentType() {
        return assignmentType;
    }
    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }
}
