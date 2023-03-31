package com.example.TheaterManager.service;

import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.view.TheaterView;

public interface TheaterService {

    Theater findTheaterByName(String name);

    void createTheater(TheaterView view);
}
