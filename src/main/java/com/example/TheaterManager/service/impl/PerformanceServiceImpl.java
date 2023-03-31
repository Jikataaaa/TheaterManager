package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.entities.Performance;
import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.entities.TicketOffice;
import com.example.TheaterManager.models.view.PerformanceView;
import com.example.TheaterManager.repository.PerformanceRepository;
import com.example.TheaterManager.service.PerformanceService;
import com.example.TheaterManager.service.TheaterService;
import com.example.TheaterManager.service.TicketOfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final TheaterService theaterService;

    private final TicketOfficeService ticketOfficeService;


    @Override
    public void createPerformance(PerformanceView performanceView) {
        modifyPerformance(performanceView);
    }

    @Override
    public void addTicketOfficeToPerformance(Long ticketOfficeId, Long performanceId) {
        TicketOffice ticketOffice = ticketOfficeService.findTicketOfficeById(ticketOfficeId);
        Performance performance = performanceRepository.findById(performanceId).orElseThrow();
        performance.getTicketOffices().add(ticketOffice);
        performanceRepository.save(performance);

    }

    @Override
    public void editPerformance(PerformanceView performanceView) {
        modifyPerformance(performanceView);
    }

    private void modifyPerformance(PerformanceView view){
        Theater theaterByName = theaterService.findTheaterByName(view.getTheaterName());


        Performance performance = Performance
                .builder()
                .description(view.getDescription())
                .genre(view.getGenre())
                .name(view.getName())
                .theater(theaterByName)
                .startTime(view.getStartTime())
                .build();

        performanceRepository.save(performance);
    }
}
