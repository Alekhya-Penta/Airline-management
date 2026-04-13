package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}
