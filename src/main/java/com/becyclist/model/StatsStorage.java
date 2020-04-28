package com.becyclist.model;

public class StatsStorage {

    private static final StatsStorage storage = new StatsStorage();

    private StatsStorage() {
        this.numberOfSearchs = 0;
        this.numberOfEvents = 5;
    };

    public static StatsStorage getInstance() {
        return storage;
    }

    private Integer numberOfEvents;

    private Integer numberOfSearchs;

    private String lastSearchTerm;

    public Integer getNumberOfEvents() {
        return numberOfEvents;
    }

    public void increaseNumberOfEvents() { this.numberOfEvents++; }

    public void decreaseNumberOfEvents() {
        this.numberOfEvents--;
    }

    public Integer getNumberOfSearchs() { return numberOfSearchs; }

    public void increaseNumberOfSearchs() { this.numberOfSearchs++; }

    public String getLastSearchTerm() {
        return lastSearchTerm;
    }

    public void setLastSearchTerm(String lastSearchTerm) {
        this.lastSearchTerm = lastSearchTerm;
    }
}
