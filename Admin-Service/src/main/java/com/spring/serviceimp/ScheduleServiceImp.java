package com.spring.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Schedule;
import com.spring.repo.ScheduleRepository;
import com.spring.service.ScheduleService;

@Service
public class ScheduleServiceImp implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Long id, Schedule schedule) {
        Optional<Schedule> existingOpt = scheduleRepository.findById(id);
        if (existingOpt.isPresent()) {
            Schedule existing = existingOpt.get();
            existing.setScheduleTime(schedule.getScheduleTime());
            existing.setFlight(schedule.getFlight());
            return scheduleRepository.save(existing);
        } else {
            throw new RuntimeException("Schedule not found");
        }
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }
}