package com.example.TheaterManager.service;
import com.example.TheaterManager.models.view.PerformanceView;

public interface PerformanceService {

    void createPerformance(PerformanceView performanceView);

    void addTicketOfficeToPerformance(Long id, Long PerformanceId);

    void editPerformance(PerformanceView performanceView);
}
