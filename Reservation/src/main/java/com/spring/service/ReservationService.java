package com.spring.service;

import java.util.List;

import com.spring.entity.Reservation;

public interface ReservationService {
	Reservation createReservation(Reservation res);
    void cancelReservation(Long id);
    List<Reservation> getReservationsByUserId(Long userId);
	Reservation getReservationById(Long id);
}