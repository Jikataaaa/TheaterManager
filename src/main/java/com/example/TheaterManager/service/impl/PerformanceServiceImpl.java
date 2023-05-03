package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.entities.Performance;
import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.entities.TicketOffice;
import com.example.TheaterManager.models.view.PerformanceView;
import com.example.TheaterManager.repository.PerformanceRepository;
import com.example.TheaterManager.service.PerformanceService;
import com.example.TheaterManager.service.TheaterService;
import com.example.TheaterManager.service.TicketOfficeService;
import com.example.TheaterManager.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final TheaterService theaterService;

    private final TicketOfficeService ticketOfficeService;


    @Override
    public PerformanceView createPerformance(PerformanceView performanceView) {
       return modifyPerformance(performanceView);
    }

    @Override
    public PerformanceView addTicketOfficeToPerformance(Long ticketOfficeId, Long performanceId) {
        TicketOffice ticketOffice = ticketOfficeService.findTicketOfficeById(ticketOfficeId);
        Performance performance = performanceRepository.findById(performanceId).orElseThrow();
        performance.getTicketOffices().add(ticketOffice);
        Performance save = performanceRepository.save(performance);
        return PerformanceView
                .builder()
                .genre(save.getGenre())
                .theaterName(save.getTheater().getName())
                .description(save.getDescription())
                .name(save.getName())
                .startTime(save.getStartTime())
                .build();
    }

    @Override
    public PerformanceView editPerformance(PerformanceView performanceView) {
       return modifyPerformance(performanceView);
    }

    @Override
    public List<PerformanceView> findAllPerformances() {
        return performanceRepository.findAllByStartTime().stream().map(performance -> PerformanceView
                        .builder()
                        .theaterName(performance.getTheater().getName())
                        .startTime(performance.getStartTime())
                        .name(performance.getName())
                        .description(performance.getDescription())
                        .genre(performance.getGenre())
                        .build())
                .toList();
    }

    private PerformanceView modifyPerformance(PerformanceView view){
        Theater theaterByName = theaterService.findTheaterByName(view.getTheaterName());

        Instant instant = DateUtil.parseInstant(view.getStartTime());
        instant = DateUtil.changeTimeOfInstant(instant, view.getTime());


        Performance performance = Performance
                .builder()
                .description(view.getDescription())
                .genre(view.getGenre())
                .name(view.getName())
                .theater(theaterByName)
                .startTime(instant)
                .build();


        Performance save = performanceRepository.save(performance);

        return PerformanceView
                .builder()
                .genre(save.getGenre())
                .theaterName(save.getTheater().getName())
                .description(save.getDescription())
                .name(save.getName())
                .startTime(save.getStartTime())
                .build();
    }
}
