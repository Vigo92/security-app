package com.vigo.securityapp.service.impl;

import com.vigo.securityapp.model.dto.EventDTO;
import com.vigo.securityapp.model.entity.Event;
import com.vigo.securityapp.repository.EventRepository;
import com.vigo.securityapp.service.BaseService;
import com.vigo.securityapp.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 24/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService, BaseService<Event, EventDTO> {

    private final EventRepository eventRepository;


    @Override
    public EventDTO convertEntityToData(Event event) {
        return null;
    }

    @Override
    public Event convertDataToEntity(EventDTO eventDTO) {
        return null;
    }
}
