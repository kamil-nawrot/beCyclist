package com.becyclist.service;

import com.becyclist.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    List<Event> findAllEvents(String name, LocalDate dateFrom, LocalDate dateTo);

    Event addEvent(Event body);
}
