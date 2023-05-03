package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.view.TheaterNameView;
import com.example.TheaterManager.models.view.TheaterView;
import com.example.TheaterManager.repository.TheaterRepository;
import com.example.TheaterManager.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public TheaterView createTheater(TheaterView view) {
        Theater save = theaterRepository.save(mapper.map(view, Theater.class));
        return mapper.map(save, TheaterView.class);
    }

    @Override
    public List<TheaterNameView> getTheaterNames() {
        List<Theater> all = theaterRepository.findAll();

       return all
               .stream()
               .map(e -> mapper.map(e, TheaterNameView.class))
               .toList();
    }
}
