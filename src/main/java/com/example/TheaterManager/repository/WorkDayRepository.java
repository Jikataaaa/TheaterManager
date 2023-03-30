package com.example.TheaterManager.repository;

import com.example.TheaterManager.models.entities.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
}
