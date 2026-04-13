package com.spring.service;

import java.util.List;
import com.spring.entity.Itinerary;
import com.spring.entity.Passengers;

public interface ItineraryService {
    /**
     * Create a new itinerary for a user with selected flights and passengers.
     *
     * @param userId     the ID of the user
     * @param flightIds  list of flight IDs to include in the itinerary
     * @param passengers list of Passengers in the itinerary
     * @return the created Itinerary
     */
    Itinerary createItinerary(Long userId, List<Long> flightIds, List<Passengers> passengers);

    /**
     * Get an existing itinerary by its ID.
     */
    Itinerary getItinerary(Long itineraryId);

    /**
     * Cancel an existing itinerary.
     */
    void cancelItinerary(Long itineraryId);

    /**
     * Get all itineraries for a user.
     */
    List<Itinerary> getUserItineraries(Long userId);
}