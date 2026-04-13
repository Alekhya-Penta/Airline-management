package com.spring.controller;


// package com.spring.flight.controller
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.FlightDto;
import com.spring.dto.FlightRequestDto;
import com.spring.entity.Aircraft;
import com.spring.entity.Flight;
import com.spring.repo.AircraftRepository;
import com.spring.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping("/search")
    public List<FlightDto> searchFlights(@RequestParam String src, @RequestParam String dest) {
        return flightService.searchFlights(src, dest);
    }

    @PostMapping("/add")
    public FlightDto addFlight(@RequestBody FlightRequestDto request) {
        // Fetch the existing Aircraft entity
        Aircraft aircraft = aircraftRepository.findById(request.getAircraftId())
            .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        // Map DTO to Entity
        Flight flight = new Flight();
        flight.setSource(request.getSource());
        flight.setDestination(request.getDestination());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setStatus(request.getStatus());
        flight.setAircraft(aircraft);

        // Call service to save
        return flightService.addFlight(flight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightRequestDto> getFlightById(@PathVariable Long id) {
        FlightRequestDto flightDto = flightService.getFlightSummaryById(id);
        if (flightDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flightDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/schedule")
    public List<FlightDto> getFlightsBySchedule(@RequestParam String start, @RequestParam String end) {
        return flightService.searchBySchedule(start, end);
    }
}