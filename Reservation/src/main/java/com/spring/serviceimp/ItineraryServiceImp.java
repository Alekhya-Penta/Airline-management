package com.spring.serviceimp;

import com.spring.service.ItineraryService;
import com.spring.dto.FlightSummaryDto;
import com.spring.entity.Itinerary;
import com.spring.entity.Passengers;
import com.spring.repo.ItineraryRepository;
import com.spring.service.FlightApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItineraryServiceImp implements ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private FlightApiClient flightApiClient; // To fetch flight info

    @Override
    public Itinerary createItinerary(Long userId, List<Long> flightIds, List<Passengers> passengers) {
        // Validate flight IDs by calling flight API
        for (Long flightId : flightIds) {
            FlightSummaryDto flightDto = flightApiClient.getFlightById(flightId);
            if (flightDto == null) {
                throw new RuntimeException("Flight ID " + flightId + " not found");
            }
            // Optionally, do more validation (e.g., status, time conflicts)
        }

        // Create and save the itinerary
        Itinerary itinerary = new Itinerary();
        itinerary.setUserId(userId);
        itinerary.setPassengers(passengers);
        itinerary.setStatus("Booked");
        // Store only userId, passengers, status. If you want to connect flights,
        // you can store flight IDs or full Flight entities if schema allows.
        return itineraryRepository.save(itinerary);
    }

    @Override
    public Itinerary getItinerary(Long id) {
        return itineraryRepository.findById(id).orElse(null);
    }

    @Override
    public void cancelItinerary(Long id) {
        Itinerary itinerary = getItinerary(id);
        if (itinerary != null) {
            itinerary.setStatus("Cancelled");
            itineraryRepository.save(itinerary);
        }
    }

    @Override
    public List<Itinerary> getUserItineraries(Long userId) {
        // Implement as per your schema, e.g., find by userId
        // return itineraryRepository.findByUserId(userId);
        return null; // Placeholder
    }
}