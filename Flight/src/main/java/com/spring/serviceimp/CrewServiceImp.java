package com.spring.serviceimp;




import com.spring.entity.CrewMember;
import com.spring.dto.AircraftDto;
import com.spring.dto.CrewAssignmentDto;
import com.spring.dto.CrewMemberDto;
import com.spring.dto.FlightDto;
import com.spring.entity.Aircraft;
import com.spring.entity.CrewAssignment;
import com.spring.entity.Flight; // Assuming exists
import com.spring.repo.CrewAssignmentRepository;
import com.spring.repo.CrewMemberRepository;
import com.spring.repo.FlightRepository;
import com.spring.service.CrewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrewServiceImp implements CrewService {

    @Autowired
    private CrewMemberRepository crewMemberRepo;

    @Autowired
    private CrewAssignmentRepository crewAssignmentRepo;

    @Autowired
    private FlightRepository flightRepo; // Your existing Flight repository

    @Override
    public CrewMemberDto addCrewMember(CrewMemberDto crewMemberDto) {
        // Map DTO to Entity
        CrewMember crewEntity = new CrewMember();
        crewEntity.setName(crewMemberDto.getName());
        crewEntity.setRole(crewMemberDto.getRole());

        // Save Entity
        CrewMember saved = crewMemberRepo.save(crewEntity);

        // Map Entity back to DTO (if needed)
        return new CrewMemberDto(saved.getId(), saved.getName(), saved.getRole());
    }

    @Override
    public void assignCrewToFlight(Long crewMemberId, Long flightId, String assignmentType) {
        CrewMember crew = crewMemberRepo.findById(crewMemberId).orElseThrow(() -> new RuntimeException("CrewMember not found"));
        Flight flight = flightRepo.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));

        CrewAssignment assignment = new CrewAssignment(crew, flight, assignmentType);
        crewAssignmentRepo.save(assignment);
    }

    @Override
    public List<CrewMemberDto> getAllCrewMembers() {
        return crewMemberRepo.findAll().stream()
            .map(c -> new CrewMemberDto(c.getId(), c.getName(), c.getRole()))
            .collect(Collectors.toList());
    }

   
    @Override
    public List<CrewAssignmentDto> getAssignmentsByFlight(Long flightId) {
        return crewAssignmentRepo.findAll().stream()
            .filter(ca -> ca.getFlight().getId().equals(flightId))
            .map(ca -> {
                // Convert CrewMember entity to DTO
                CrewMember crew = ca.getCrewMember();
                CrewMemberDto crewDto = new CrewMemberDto(crew.getId(), crew.getName(), crew.getRole());

                // Convert Flight entity to DTO with inline mapping, including Aircraft info
                Flight flight = ca.getFlight();
                Aircraft aircraft = flight.getAircraft();

                AircraftDto aircraftDto = null;
                if (aircraft != null) {
                    aircraftDto = new AircraftDto(
                        aircraft.getId(),
                        aircraft.getModel(),
                        aircraft.getRegistrationNumber(),
                        aircraft.getCapacity()
                    );
                }

                FlightDto flightDto = new FlightDto(
                    flight.getId(),
                    flight.getSource(),
                    flight.getDestination(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getStatus(),
                    aircraftDto
                );

                return new CrewAssignmentDto(
                    ca.getId(),
                    crewDto,
                    flightDto,
                    ca.getAssignmentType()
                );
            })
            .collect(Collectors.toList());
    }
}
