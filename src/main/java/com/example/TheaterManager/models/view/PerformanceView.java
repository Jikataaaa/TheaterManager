package com.example.TheaterManager.models.view;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PerformanceView {

    private String name;
    private String description;
    private String genre;
    private LocalDateTime startTime;
    private String theaterName;

}
