package com.spring.service;

import java.util.List;
import com.spring.entity.Flight;

public interface FlightService {
    Flight addFlight(Flight flight);
    Flight updateFlight(Long id, Flight flight);
    void deleteFlight(Long id);
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
}