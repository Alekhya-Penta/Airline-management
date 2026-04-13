package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
