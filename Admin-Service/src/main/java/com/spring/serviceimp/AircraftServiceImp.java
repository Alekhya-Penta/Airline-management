package com.spring.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Aircraft;
import com.spring.repo.AircraftRepository;
import com.spring.service.AircraftService;

@Service
public class AircraftServiceImp implements AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Optional<Aircraft> existingAircraftOpt = aircraftRepository.findById(id);
        if (existingAircraftOpt.isPresent()) {
            Aircraft existingAircraft = existingAircraftOpt.get();
            existingAircraft.setModel(aircraft.getModel());
            existingAircraft.setRegistrationNumber(aircraft.getRegistrationNumber());
            existingAircraft.setCapacity(aircraft.getCapacity());
            return aircraftRepository.save(existingAircraft);
        } else {
            throw new RuntimeException("Aircraft not found with id " + id);
        }
    }

    @Override
    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found with id " + id));
    }
}