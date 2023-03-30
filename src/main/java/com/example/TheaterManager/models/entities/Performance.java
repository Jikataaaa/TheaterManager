package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Performance extends BaseEntity {

    private String name;
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "id")
    private Theater theater;

    @OneToMany
    @JoinColumn(name = "ticket_office_id", referencedColumnName = "id")
    private Set<TicketOffice> ticketOffices;

}
