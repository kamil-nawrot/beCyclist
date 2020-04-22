package com.becyclist.api;

import com.becyclist.model.Event;
import com.becyclist.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class EventApiController implements EventApi {

    @Autowired
    private EventService eventService;

    private static final Logger log = LoggerFactory.getLogger(EventApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EventApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public String index() {
        return "Hello world from Spring Boot Web Application!";
    }

    public ResponseEntity<List<Event>> findAllEvents(
            @ApiParam(value = "") @Valid @RequestParam(value = "name", required = false)
                    String name,
            @ApiParam(value = "") @Valid @RequestParam(value = "dateFrom", required = false)
                    String dateFrom,
            @ApiParam(value = "") @Valid @RequestParam(value = "dateTo", required = false)
                    String dateTo) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate localDateFrom = dateFrom != null ? LocalDate.parse(dateFrom, formatter) : null;
        LocalDate localDateTo = dateTo != null ? LocalDate.parse(dateTo, formatter) : null;

        List<Event> events;
        events = (eventService.findAllEvents(name, localDateFrom, localDateTo));
        return ResponseEntity.ok(events);
    }

    public ResponseEntity<Event> addEvent(@ApiParam(value = "", required = true) @Valid @RequestBody Event body) {

        return ResponseEntity.ok(eventService.addEvent(body));
    }

    @Override
    public ResponseEntity<Event> getEvent(Long eventId) {
        try {
            return ResponseEntity.ok(eventService.findEvent(eventId));
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Event> updateEvent(@Valid Event event) {
        return null;
    }
}
