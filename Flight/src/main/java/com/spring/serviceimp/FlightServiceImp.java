package com.spring.serviceimp;

//package com.spring.flight.serviceimpl
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AircraftDto;
import com.spring.dto.FlightDto;
import com.spring.dto.FlightRequestDto;
import com.spring.entity.Aircraft;
import com.spring.entity.Flight;
import com.spring.repo.CrewAssignmentRepository;
import com.spring.repo.FlightRepository;
import com.spring.service.FlightService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImp implements FlightService {

 @Autowired
 private FlightRepository flightRepository;
 
 @Autowired
 private CrewAssignmentRepository crewAssignmentRepository;

 @Override
 public List<FlightDto> searchFlights(String src, String dest) {
     List<Flight> flights = flightRepository.findBySourceAndDestination(src, dest);
     return flights.stream().map(flight -> {
         // Inline mapping
         Aircraft aircraft = flight.getAircraft();
         AircraftDto aircraftDTO = null;
         if (aircraft != null) {
             aircraftDTO = new AircraftDto(
                     aircraft.getId(),
                     aircraft.getModel(),
                     aircraft.getRegistrationNumber(),
                     aircraft.getCapacity()
             );
         }
         return new FlightDto(
                 flight.getId(),
                 flight.getSource(),
                 flight.getDestination(),
                 flight.getDepartureTime(),
                 flight.getArrivalTime(),
                 flight.getStatus(),
                 aircraftDTO
         );
     }).collect(Collectors.toList());
 }

 @Override
 public FlightDto addFlight(Flight flight) {
     Flight saved = flightRepository.save(flight);
     Aircraft aircraft = saved.getAircraft();
     AircraftDto aircraftDTO = null;
     if (aircraft != null) {
         aircraftDTO = new AircraftDto(
                 aircraft.getId(),
                 aircraft.getModel(),
                 aircraft.getRegistrationNumber(),
                 aircraft.getCapacity()
         );
     }
     return new FlightDto(
             saved.getId(),
             saved.getSource(),
             saved.getDestination(),
             saved.getDepartureTime(),
             saved.getArrivalTime(),
             saved.getStatus(),
             aircraftDTO
     );
 }

 @Override
// public void deleteFlight(Long id) {
//     flightRepository.deleteById(id);
// }
 @Transactional
 public void deleteFlight(Long id) {
     // Fetch the Flight entity
     Flight flight = flightRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Flight not found"));

     // The cascade = CascadeType.ALL in your entity will delete crew assignments automatically
     flightRepository.delete(flight);
 }

 @Override
 public List<FlightDto> searchBySchedule(String start, String end) {
     List<Flight> flights = flightRepository.findByDepartureTimeBetween(start, end);
     return flights.stream().map(flight -> {
         Aircraft aircraft = flight.getAircraft();
         AircraftDto aircraftDTO = null;
         if (aircraft != null) {
             aircraftDTO = new AircraftDto(
                     aircraft.getId(),
                     aircraft.getModel(),
                     aircraft.getRegistrationNumber(),
                     aircraft.getCapacity()
             );
         }
         return new FlightDto(
                 flight.getId(),
                 flight.getSource(),
                 flight.getDestination(),
                 flight.getDepartureTime(),
                 flight.getArrivalTime(),
                 flight.getStatus(),
                 aircraftDTO
         );
     }).collect(Collectors.toList());
 }
 
 @Override
 
 public FlightRequestDto getFlightSummaryById(Long id) {
     Flight flight = flightRepository.findById(id).orElse(null);
     if (flight == null) {
         return null; // or throw new RuntimeException("Flight not found");
     }
     // Map entity to DTO
     return new FlightRequestDto(
         flight.getId(),
         flight.getSource(),
         flight.getDestination(),
         flight.getDepartureTime(),
         null, // arrivalTime not included in summary
         null, // status not included
         null  // aircraft info not included
     );
 }
}