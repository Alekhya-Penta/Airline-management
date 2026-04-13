package com.spring.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.entity.CrewMember;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> { }
