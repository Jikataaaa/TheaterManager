package com.example.TheaterManager.repository;

import com.example.TheaterManager.models.entities.TicketOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketOfficeRepository extends JpaRepository<TicketOffice, Long> {
}
