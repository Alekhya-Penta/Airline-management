package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.dto.FlightSummaryDto;

@Component
public class FlightApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8084/api/flight";

    public FlightSummaryDto getFlightById(Long flightId) {
        String url = BASE_URL + "/" + flightId;
        return restTemplate.getForObject(url, FlightSummaryDto.class);
    }
}
