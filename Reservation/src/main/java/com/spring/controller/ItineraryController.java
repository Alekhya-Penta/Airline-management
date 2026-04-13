package com.spring.controller;



import com.spring.entity.Passengers;
import com.spring.entity.Itinerary;
import com.spring.service.ItineraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing itineraries in the Reservation microservice.
 */
@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    /**
     * Create a new itinerary.
     *
     * @param request the request payload containing userId, flightIds, passengers
     * @return the created Itinerary
     */
    @PostMapping
    public ResponseEntity<Itinerary> createItinerary(@RequestBody CreateItineraryRequest request) {
        Itinerary itinerary = itineraryService.createItinerary(
                request.getUserId(),
                request.getFlightIds(),
                request.getPassengers()
        );
        return ResponseEntity.ok(itinerary);
    }

    /**
     * Get details of a specific itinerary by ID.
     *
     * @param id the itinerary ID
     * @return the Itinerary if found, 404 otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItinerary(@PathVariable Long id) {
        Itinerary itinerary = itineraryService.getItinerary(id);
        if (itinerary == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itinerary);
    }

    /**
     * Cancel an existing itinerary (change status to "Cancelled").
     *
     * @param id the itinerary ID
     * @return success message
     */
    @PostMapping("/{id}/cancel")
    public ResponseEntity<String> cancelItinerary(@PathVariable Long id) {
        itineraryService.cancelItinerary(id);
        return ResponseEntity.ok("Itinerary canceled successfully");
    }

    /**
     * Get all itineraries for a specific user.
     *
     * @param userId the user ID
     * @return list of itineraries
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Itinerary>> getUserItineraries(@PathVariable Long userId) {
        List<Itinerary> itineraries = itineraryService.getUserItineraries(userId);
        return ResponseEntity.ok(itineraries);
    }

    /**
     * Request payload class for creating an itinerary.
     */
    public static class CreateItineraryRequest {
        private Long userId;
        private List<Long> flightIds;
        private List<Passengers> passengers;

        // Getters and setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public List<Long> getFlightIds() {
            return flightIds;
        }

        public void setFlightIds(List<Long> flightIds) {
            this.flightIds = flightIds;
        }

        public List<Passengers> getPassengers() {
            return passengers;
        }

        public void setPassengers(List<Passengers> passengers) {
            this.passengers = passengers;
        }
    }
}
