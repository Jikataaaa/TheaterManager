package com.example.TheaterManager.service.impl;

import com.example.TheaterManager.models.entities.TicketOffice;
import com.example.TheaterManager.models.view.TicketOfficeView;
import com.example.TheaterManager.repository.TicketOfficeRepository;
import com.example.TheaterManager.service.TicketOfficeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketOfficeServiceImpl implements TicketOfficeService {
    private final TicketOfficeRepository repository;
    private final ModelMapper mapper;
    @Override
    public void createTicketOffice(TicketOfficeView view) {
        repository.save(mapper.map(view, TicketOffice.class));
    }

    @Override
    public TicketOffice findTicketOfficeById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
