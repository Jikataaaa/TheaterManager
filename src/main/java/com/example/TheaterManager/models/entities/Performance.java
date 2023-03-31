package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import jakarta.persistence.*;
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
    private String genre;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime startTime;

    @ManyToOne
    private Theater theater;

    @ManyToMany
    private Set<TicketOffice> ticketOffices;

}
