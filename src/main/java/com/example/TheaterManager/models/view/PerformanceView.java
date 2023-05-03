package com.example.TheaterManager.models.view;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class PerformanceView {

    private String name;
    private String description;
    private String genre;
    private LocalDateTime time;
    private String theaterName;

}
