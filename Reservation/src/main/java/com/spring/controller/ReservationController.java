package com.spring.controller;



import com.spring.entity.Reservation;
import com.spring.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/book")
    public Reservation book(@RequestBody Reservation res) {
        return reservationService.createReservation(res);
    }

    @DeleteMapping("/{id}")
    public String cancel(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return "Reservation canceled";
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getByUserId(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }
}