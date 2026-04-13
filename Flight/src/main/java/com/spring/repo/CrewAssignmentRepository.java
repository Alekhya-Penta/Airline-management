package com.spring.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.entity.CrewAssignment;

@Repository
public interface CrewAssignmentRepository extends JpaRepository<CrewAssignment, Long>
{ 
	 void deleteByFlightId(Long flightId);
}