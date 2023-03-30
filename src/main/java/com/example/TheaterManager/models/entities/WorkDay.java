package com.example.TheaterManager.models.entities;

import com.example.TheaterManager.models.BaseEntity;
import com.example.TheaterManager.models.enums.DaysOfWeek;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkDay extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private DaysOfWeek name;
    private LocalDateTime startWorkTime;
    private LocalDateTime endWorkTime;

    private String ticketOfficeName;


}
