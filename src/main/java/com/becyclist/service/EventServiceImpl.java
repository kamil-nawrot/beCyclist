package com.becyclist.service;

import com.becyclist.model.Event;
import com.becyclist.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAllEvents(String name, LocalDate dateFrom, LocalDate dateTo) {
        System.out.print(name);
        List<Event> foundNames;
        List<Event> foundDates;
        if (name != null) foundNames = eventRepository.findByNameContaining(name);
        else foundNames = eventRepository.findAll();

        if (dateFrom != null && dateTo != null) foundDates = eventRepository.findByDateBetween(dateFrom, dateTo);
        else foundDates = eventRepository.findAll();

        return foundNames.stream().filter(foundDates::contains).collect(Collectors.toList());
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
}
