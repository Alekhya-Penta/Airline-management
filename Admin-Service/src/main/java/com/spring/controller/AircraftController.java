package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.AircraftDTO;
import com.spring.entity.Aircraft;
import com.spring.service.AircraftService;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {
    
    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public List<AircraftDTO> getAllAircrafts() {
        List<Aircraft> list = aircraftService.getAllAircrafts();
        return list.stream()
                   .map(aircraft -> {
                       AircraftDTO dto = new AircraftDTO();
                       dto.setAircraftid(aircraft.getAircraftid());
                       dto.setModel(aircraft.getModel());
                       dto.setRegistrationNumber(aircraft.getRegistrationNumber());
                       dto.setCapacity(aircraft.getCapacity());
                       return dto;
                   })
                   .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftDTO> getAircraftById(@PathVariable Long id) {
        Aircraft aircraft = aircraftService.getAircraftById(id);
        AircraftDTO dto = new AircraftDTO();
        dto.setAircraftid(aircraft.getAircraftid());
        dto.setModel(aircraft.getModel());
        dto.setRegistrationNumber(aircraft.getRegistrationNumber());
        dto.setCapacity(aircraft.getCapacity());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AircraftDTO> createAircraft(@RequestBody AircraftDTO dto) {
        // Convert DTO to Entity inline
        Aircraft aircraft = new Aircraft();
        // set only if needed; id can be left null for new entities
        aircraft.setModel(dto.getModel());
        aircraft.setRegistrationNumber(dto.getRegistrationNumber());
        aircraft.setCapacity(dto.getCapacity());

        Aircraft saved = aircraftService.addAircraft(aircraft);
        // Convert Entity to DTO inline
        AircraftDTO responseDto = new AircraftDTO();
        responseDto.setAircraftid(saved.getAircraftid());
        responseDto.setModel(saved.getModel());
        responseDto.setRegistrationNumber(saved.getRegistrationNumber());
        responseDto.setCapacity(saved.getCapacity());

        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AircraftDTO> updateAircraft(@PathVariable Long id, @RequestBody AircraftDTO dto) {
        // Convert DTO to Entity
        Aircraft aircraft = new Aircraft();
        aircraft.setModel(dto.getModel());
        aircraft.setRegistrationNumber(dto.getRegistrationNumber());
        aircraft.setCapacity(dto.getCapacity());

        Aircraft updated = aircraftService.updateAircraft(id, aircraft);

        // Convert Entity to DTO
        AircraftDTO responseDto = new AircraftDTO();
        responseDto.setAircraftid(updated.getAircraftid());
        responseDto.setModel(updated.getModel());
        responseDto.setRegistrationNumber(updated.getRegistrationNumber());
        responseDto.setCapacity(updated.getCapacity());

        return ResponseEntity.ok(responseDto);
    }
}