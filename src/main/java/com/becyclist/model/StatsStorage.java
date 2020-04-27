package com.becyclist.model;

public class StatsStorage {

    private static final StatsStorage storage = new StatsStorage();

    private StatsStorage() {
        this.numberOfEvents = 5;
    };

    public static StatsStorage getInstance() {
        return storage;
    }

    private Integer numberOfEvents;

    public Integer getNumberOfEvents() {
        return numberOfEvents;
    }

    public void increaseNumberOfEvents() { this.numberOfEvents++; }

    public void decreaseNumberOfEvents() {
        this.numberOfEvents--;
    }
}
