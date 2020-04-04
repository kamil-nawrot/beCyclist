package com.becyclist.api;

import com.becyclist.model.Event;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(value = "event")
public interface EventApi {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "events", produces = "application/json", method = GET)
    ResponseEntity<List<Event>> findAllEvents(String name, String dateFrom, String dateTo);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "events", consumes = "application/json", method = POST)
    ResponseEntity<Event> addEvent(@Valid @RequestBody Event body);
}
