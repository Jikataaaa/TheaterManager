package com.example.TheaterManager.service;

import com.example.TheaterManager.models.entities.TicketOffice;
import com.example.TheaterManager.models.view.TicketOfficeView;

public interface TicketOfficeService {

    void createTicketOffice(TicketOfficeView view);

    TicketOffice findTicketOfficeById(Long id);
}
