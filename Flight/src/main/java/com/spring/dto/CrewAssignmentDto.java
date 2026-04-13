package com.spring.dto;


public class CrewAssignmentDto {
    private Long id;
    private CrewMemberDto crewMember;
    private FlightDto flight;
    private String assignmentType;

    public CrewAssignmentDto() {}

    public CrewAssignmentDto(Long id, CrewMemberDto crewMember, FlightDto flight, String assignmentType) {
        this.id = id;
        this.crewMember = crewMember;
        this.flight = flight;
        this.assignmentType = assignmentType;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CrewMemberDto getCrewMember() {
		return crewMember;
	}

	public void setCrewMember(CrewMemberDto crewMember) {
		this.crewMember = crewMember;
	}

	public FlightDto getFlight() {
		return flight;
	}

	public void setFlight(FlightDto flight) {
		this.flight = flight;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	@Override
	public String toString() {
		return "CrewAssignmentDto [id=" + id + ", crewMember=" + crewMember + ", flight=" + flight + ", assignmentType="
				+ assignmentType + "]";
	}

   
}