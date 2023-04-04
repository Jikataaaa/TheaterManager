package com.example.TheaterManager.web;

import com.example.TheaterManager.models.view.PerformanceView;
import com.example.TheaterManager.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performance")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @GetMapping("/all-performances")
    public ResponseEntity<List<PerformanceView>> getAllPerformances(){
        return ResponseEntity.ok(performanceService.findAllPerformances());
    }
    @PostMapping("/create-performance")
    public ResponseEntity<PerformanceView> createPerformance(@RequestBody PerformanceView view){
        return ResponseEntity.ok(performanceService.createPerformance(view));
    }
    @PutMapping("/edit-performance")
    public ResponseEntity<PerformanceView> editPerformance(@RequestBody PerformanceView view){
        return ResponseEntity.ok(performanceService.editPerformance(view));
    }
    @PostMapping("/add-ticketOffice")
    public ResponseEntity<PerformanceView> createPerformance(@RequestParam("ticketOfficeId") Long id, @RequestParam("ticketOfficeId") Long performanceId){
        return ResponseEntity.ok(performanceService.addTicketOfficeToPerformance(id, performanceId));
    }


}
