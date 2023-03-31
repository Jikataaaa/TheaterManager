package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.view.TheaterView;
import com.example.TheaterManager.repository.TheaterRepository;
import com.example.TheaterManager.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    private final ModelMapper mapper;

    @Override
    public Theater findTheaterByName(String name) {
        return theaterRepository.findByName(name);
    }

    @Override
    public void createTheater(TheaterView view) {
        theaterRepository.save(mapper.map(view, Theater.class));
    }
}
