package com.example.TheaterManager.service;

import com.example.TheaterManager.models.entities.Theater;
import com.example.TheaterManager.models.view.TheaterNameView;
import com.example.TheaterManager.models.view.TheaterView;

import java.util.List;

public interface TheaterService {

    Theater findTheaterByName(String name);

    TheaterView createTheater(TheaterView view);

    List<TheaterNameView> getTheaterNames();
}
