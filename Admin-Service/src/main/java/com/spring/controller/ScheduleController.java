package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.ScheduleDTO;
import com.spring.entity.Schedule;
import com.spring.repo.FlightRepository;
import com.spring.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private FlightRepository flightRepository;

    // GET all schedules
    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService.getAllSchedules().stream().map(s -> {
            return new ScheduleDTO(
                s.getId(),
                s.getScheduleTime(),
                s.getFlight().getId()
            );
        }).collect(Collectors.toList());
    }

    // GET schedule by id
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable Long id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        ScheduleDTO dto = new ScheduleDTO(
            schedule.getId(),
            schedule.getScheduleTime(),
            schedule.getFlight().getId()
        );
        return ResponseEntity.ok(dto);
    }

    // CREATE schedule
    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setScheduleTime(dto.getScheduleTime());
        // fetch flight
        schedule.setFlight(
            flightRepository.findById(dto.getFlightId())
            .orElseThrow(() -> new RuntimeException("Flight not found"))
        );
        Schedule saved = scheduleService.addSchedule(schedule);
        // Convert to DTO
        ScheduleDTO responseDto = new ScheduleDTO(
            saved.getId(),
            saved.getScheduleTime(),
            saved.getFlight().getId()
        );
        return ResponseEntity.ok(responseDto);
    }

    // UPDATE schedule
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setScheduleTime(dto.getScheduleTime());
        // fetch flight
        schedule.setFlight(
            flightRepository.findById(dto.getFlightId())
            .orElseThrow(() -> new RuntimeException("Flight not found"))
        );
        Schedule updated = scheduleService.updateSchedule(id, schedule);
        // Convert to DTO
        ScheduleDTO responseDto = new ScheduleDTO(
            updated.getId(),
            updated.getScheduleTime(),
            updated.getFlight().getId()
        );
        return ResponseEntity.ok(responseDto);
    }

    // DELETE schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}