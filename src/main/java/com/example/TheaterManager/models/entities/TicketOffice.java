package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketOffice extends BaseEntity {

    private String address;

    @OneToMany
    private Set<WorkDay> workDays;


}
