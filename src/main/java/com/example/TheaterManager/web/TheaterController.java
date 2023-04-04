package com.example.TheaterManager.web;

import com.example.TheaterManager.models.view.TheaterView;
import com.example.TheaterManager.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping()
    public ResponseEntity<TheaterView> createTheater(@RequestBody TheaterView view){
       return ResponseEntity.ok(theaterService.createTheater(view));
    }

}
