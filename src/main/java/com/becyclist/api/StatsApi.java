package com.becyclist.api;

import com.becyclist.model.StatsStorage;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(value = "stats")
public interface StatsApi {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/stats", produces = "application/json", method = GET)
    ResponseEntity<StatsStorage> getStats();
}
