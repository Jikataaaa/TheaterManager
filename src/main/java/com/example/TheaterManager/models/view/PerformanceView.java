package com.example.TheaterManager.models.view;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PerformanceView {

    private String name;
    private String description;
    private String genre;
    private LocalDateTime startTime;
    private String theaterName;

}
