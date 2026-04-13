package com.spring.service;

import java.util.List;
import com.spring.entity.Schedule;

public interface ScheduleService {
    Schedule addSchedule(Schedule schedule);
    Schedule updateSchedule(Long id, Schedule schedule);
    void deleteSchedule(Long id);
    List<Schedule> getAllSchedules();
    Schedule getScheduleById(Long id);
}