package com.spring.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Flight;
import com.spring.repo.FlightRepository;
import com.spring.service.FlightService;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Long id, Flight flight) {
        Optional<Flight> existingOpt = flightRepository.findById(id);
        if (existingOpt.isPresent()) {
            Flight existing = existingOpt.get();
            // update fields
            existing.setSource(flight.getSource());
            existing.setDestination(flight.getDestination());
            existing.setDepartureTime(flight.getDepartureTime());
            existing.setArrivalTime(flight.getArrivalTime());
            existing.setStatus(flight.getStatus());
            existing.setAircraft(flight.getAircraft());
            return flightRepository.save(existing);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}