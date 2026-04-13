package com.spring.service;



import java.util.List;
import com.spring.entity.CrewMember;
import com.spring.entity.Flight;
import com.spring.dto.CrewAssignmentDto;
import com.spring.dto.CrewMemberDto;
import com.spring.dto.FlightDto;
import com.spring.entity.CrewAssignment;

public interface CrewService {
//    CrewMember addCrewMember(CrewMember crewMember);
//    void assignCrewToFlight(Long crewMemberId, Long flightId, String assignmentType);
//    List<CrewMember> getAllCrewMembers();
//    List<CrewAssignment> getAssignmentsByFlight(Long flightId);
	
	CrewMemberDto addCrewMember(CrewMemberDto crewMemberDTO);
    void assignCrewToFlight(Long crewMemberId, Long flightId, String assignmentType);
    List<CrewMemberDto> getAllCrewMembers();
    List<CrewAssignmentDto> getAssignmentsByFlight(Long flightId);
// 
    }
    

