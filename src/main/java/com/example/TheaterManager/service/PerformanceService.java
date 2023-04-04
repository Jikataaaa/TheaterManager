package com.example.TheaterManager.service;
import com.example.TheaterManager.models.view.PerformanceView;

import java.util.List;

public interface PerformanceService {

    PerformanceView createPerformance(PerformanceView performanceView);

    PerformanceView addTicketOfficeToPerformance(Long id, Long PerformanceId);

    PerformanceView editPerformance(PerformanceView performanceView);

    List<PerformanceView> findAllPerformances();
}
