package com.spring.service;

import java.util.List;
import com.spring.entity.Aircraft;

public interface AircraftService {
    Aircraft addAircraft(Aircraft aircraft);
    Aircraft updateAircraft(Long id, Aircraft aircraft);
    void deleteAircraft(Long id);
    List<Aircraft> getAllAircrafts();
    Aircraft getAircraftById(Long id);
}