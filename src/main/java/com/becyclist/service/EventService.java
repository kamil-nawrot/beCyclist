package com.becyclist.service;

import com.becyclist.model.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAllEvents(String name, LocalDate dateFrom, LocalDate dateTo);

    Event findEvent(Long eventId);

    Event addEvent(Event body);

}
