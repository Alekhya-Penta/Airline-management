package com.spring.service;

import java.util.List;

import com.spring.dto.FlightDto;
import com.spring.dto.FlightRequestDto;
import com.spring.entity.Flight;

public interface FlightService {
//    List<Flight> searchFlights(String src, String dest);
//    Flight addFlight(Flight flight);
//    void deleteFlight(Long id);
//    List<Flight> searchBySchedule(String start, String end);//previous code
    
    List<FlightDto> searchFlights(String src, String dest);
    FlightDto addFlight(Flight flight);
   void deleteFlight(Long id);
   FlightRequestDto getFlightSummaryById(Long id);
   //void deleteFlightWithDependents(Long id);
    List<FlightDto> searchBySchedule(String start, String end);
}