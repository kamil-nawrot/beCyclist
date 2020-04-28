package com.becyclist.model;

import java.util.HashMap;

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

    public int[] fieldsCounter = {0, 0, 0};

    private HashMap<String, Double> fields = new HashMap<String, Double>() {{
        put("name", 0.00);
        put("dateFrom", 0.00);
        put("dateTo", 0.00);
    }};;

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

    public int[] getFieldsCounter() { return fieldsCounter; }

    public int getFieldCounter(int fieldIndex) {
        return fieldsCounter[fieldIndex];
    }

    public void setFieldsCounter(int[] fieldsCounter) {
        for(int i=0; i<fieldsCounter.length; i++) {
            if(fieldsCounter[i] == 1)   this.fieldsCounter[i]++;
        }

        HashMap<String, Double> fields = new HashMap<String, Double>() {{
            put("name", 1.0 * getFieldCounter(0) / getNumberOfSearchs());
            put("dateFrom", 1.0 * getFieldCounter(1) / getNumberOfSearchs());
            put("dateTo", 1.0 * getFieldCounter(2) / getNumberOfSearchs());
        }};
        this.setFields(fields);
    }

    public HashMap<String, Double> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Double> fields) {
        this.fields = fields;
    }
}
