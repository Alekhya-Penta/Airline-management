package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.FlightDTO;
import com.spring.entity.Flight;
import com.spring.repo.AircraftRepository;
import com.spring.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AircraftRepository aircraftRepository;

    // GET all flights
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights().stream().map(f -> {
            return new FlightDTO(
                f.getId(),
                f.getSource(),
                f.getDestination(),
                f.getDepartureTime(),
                f.getArrivalTime(),
                f.getStatus(),
                f.getAircraft().getAircraftid()
            );
        }).collect(Collectors.toList());
    }

    // GET flight by id
    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        FlightDTO dto = new FlightDTO(
            flight.getId(),
            flight.getSource(),
            flight.getDestination(),
            flight.getDepartureTime(),
            flight.getArrivalTime(),
            flight.getStatus(),
            flight.getAircraft().getAircraftid()
        );
        return ResponseEntity.ok(dto);
    }

    // CREATE new flight
    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO dto) {
        Flight flight = new Flight();
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setStatus(dto.getStatus());

        // fetch aircraft
        aircraftRepository.findById(dto.getAircraftId())
            .ifPresentOrElse(
                aircraft -> flight.setAircraft(aircraft),
                () -> { throw new RuntimeException("Aircraft not found"); }
            );

        Flight saved = flightService.addFlight(flight);
        FlightDTO responseDto = new FlightDTO(
            saved.getId(),
            saved.getSource(),
            saved.getDestination(),
            saved.getDepartureTime(),
            saved.getArrivalTime(),
            saved.getStatus(),
            saved.getAircraft().getAircraftid()
        );
        return ResponseEntity.ok(responseDto);
    }

    // UPDATE flight
    @PutMapping("/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @RequestBody FlightDTO dto) {
        Flight flight = new Flight();
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setStatus(dto.getStatus());

        // fetch aircraft
        aircraftRepository.findById(dto.getAircraftId())
            .ifPresentOrElse(
                aircraft -> flight.setAircraft(aircraft),
                () -> { throw new RuntimeException("Aircraft not found"); }
            );

        Flight updated = flightService.updateFlight(id, flight);
        FlightDTO responseDto = new FlightDTO(
            updated.getId(),
            updated.getSource(),
            updated.getDestination(),
            updated.getDepartureTime(),
            updated.getArrivalTime(),
            updated.getStatus(),
            updated.getAircraft().getAircraftid()
        );
        return ResponseEntity.ok(responseDto);
    }

    // DELETE flight
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}