package com.spring.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.FlightSummaryDto;
import com.spring.entity.Reservation;
import com.spring.repo.ReservationRepository;
import com.spring.service.ReservationService;



import com.spring.entity.Reservation;
import com.spring.repo.ReservationRepository;
import com.spring.service.ReservationService;
import com.spring.service.FlightApiClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightApiClient flightApiClient;

    @Override
    @Transactional
    public Reservation createReservation(Reservation res) {
        // Fetch flight info to validate (optional)
        Long flightId = res.getFlightId();
        FlightSummaryDto flightDto = null;
        try {
            flightDto = flightApiClient.getFlightById(flightId);
        } catch(Exception e) {
            throw new RuntimeException("Flight not found");
        }
        if (flightDto == null) throw new RuntimeException("Flight does not exist");

        // Save reservation with flightId
        return reservationRepository.save(res);
    }

    @Override
    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findAll().stream()
                .filter(r -> r.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }
}

