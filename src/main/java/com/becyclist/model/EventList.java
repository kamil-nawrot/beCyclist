package com.becyclist.model;

import java.io.Serializable;
import java.util.List;

public class EventList implements Serializable {

    private static final long serialVersionUID = 1L;

    protected List<Event> eventList = null;

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
