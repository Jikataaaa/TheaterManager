package com.example.TheaterManager.web;

import com.example.TheaterManager.models.view.TheaterNameView;
import com.example.TheaterManager.models.view.TheaterView;
import com.example.TheaterManager.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/theater")
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/add-theater")
    public ResponseEntity<TheaterView> createTheater(@RequestBody TheaterView view){
       return ResponseEntity.ok(theaterService.createTheater(view));
    }

    @GetMapping("/all-theaters")
    public ResponseEntity<List<TheaterNameView>> getTheatersName(){
        return ResponseEntity.ok(theaterService.getTheaterNames());
    }

}
