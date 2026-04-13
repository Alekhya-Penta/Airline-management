package com.spring.controller;

// package com.spring.flight.controller
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.CrewAssignmentDto;
import com.spring.dto.CrewMemberDto;
import com.spring.service.CrewService;

import java.util.List;


@RestController
@RequestMapping("/api/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @PostMapping("/addMember")
    public CrewMemberDto addCrew(@RequestBody CrewMemberDto dto) {
        return crewService.addCrewMember(dto);
    }

    @PostMapping("/assign")
    public String assignCrew(@RequestParam Long crewMemberId,
                               @RequestParam Long flightId,
                               @RequestParam String assignmentType) {
        crewService.assignCrewToFlight(crewMemberId, flightId, assignmentType);
        return "Assigned successfully";
    }

    @GetMapping("/members")
    public List<CrewMemberDto> getAllMembers() {
        return crewService.getAllCrewMembers();
    }

    @GetMapping("/flight/{flightId}/assignments")
    public List<CrewAssignmentDto> getAssignments(@PathVariable Long flightId) {
        return crewService.getAssignmentsByFlight(flightId);
    }
}