package com.becyclist.api;

import com.becyclist.model.Event;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(value = "event")
public interface EventApi {

    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "Find all events available in the system", nickname = "getEvents",
            notes = "Filtering parameters shall be added as request query params.",
            tags = {"events"}, response = Event.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK: All events matching given criteria returned", response = Event.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request: Something went wrong", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found: Requested resource was not found", response = Error.class),
            @ApiResponse(code = 414, message = "URI Too Long: Too many filters specified", response = Error.class)
    })
    @RequestMapping(value = "events", produces = "application/json", method = GET)
    ResponseEntity<List<Event>> findAllEvents(
            @ApiParam(value = "") @Valid @RequestParam(value = "name", required = false)
                    String name,
            @ApiParam(value = "") @Valid @RequestParam(value = "dateFrom", required = false)
                    String dateFrom,
            @ApiParam(value = "") @Valid @RequestParam(value = "dateTo", required = false)
                    String dateTo
//            @ApiParam(value = "", allowableValues = "road race, mountain cycling, track cycling, BMX, speedway, cyclo-cross") @Valid @RequestParam(value = "type", required = false)
//                    List<String> type,
//            @ApiParam(value = "", allowableValues = "amateur, beginner, normal, advanced, professional") @Valid @RequestParam(value = "difficulty", required = false)
//                    List<String> difficulty,
//            @ApiParam(value = "") @Valid @RequestParam(value = "entryFee", required = false)
//                    List<Integer> entryFee,
//            @ApiParam(value = "") @Valid @RequestParam(value = "additional", required = false)
//                    String additional
    );

    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "Create new event", nickname = "createEvent", notes = "This can be done only by verified organizer", tags = {"events"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OK: New event was created"),
            @ApiResponse(code = 400, message = "Bad Request: Something went wrong", response = Error.class),
            @ApiResponse(code = 403, message = "Unauthorized: No permission to perform this action", response = Error.class)})
    @RequestMapping(value = "events", consumes = "application/json", method = POST)
    ResponseEntity<Event> addEvent(@ApiParam(value = "", required = true) @Valid @RequestBody Event body);

    @ApiOperation(value = "Return event with specific ID", nickname = "getEvent", notes = "", tags = {"events"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK: Event with given ID returned"),
            @ApiResponse(code = 400, message = "Bad Request: Something went wrong", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found: Requested resource was not found", response = Error.class)})
    @RequestMapping(value = "/events/{eventId}", produces = {"application/json"}, method = GET)
    ResponseEntity<Event> getEvent(@ApiParam(value = "", required = true) @PathVariable("eventId") Long eventId);

    @ApiOperation(value = "Update existing event details", nickname = "updateEvent", notes = "This can be done only by verified organizer", tags = {"events",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK: New event was updated"),
            @ApiResponse(code = 400, message = "Bad Request: Something went wrong", response = Error.class),
            @ApiResponse(code = 403, message = "Unauthorized: No permission to perform this action", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found: Requested resource was not found", response = Error.class)})
    @RequestMapping(value = "/events", consumes = {"application/json", "application/xml"}, method = PUT)
    ResponseEntity<Event> updateEvent(@ApiParam(value = "", required = true) @Valid @RequestBody Event event);

    @ApiOperation(value = "Delete event with specific ID", nickname = "deleteEvent", notes = "", tags = {"events"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK: Event with given ID deleted"),
            @ApiResponse(code = 400, message = "Bad Request: Something went wrong", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found: Requested resource was not found", response = Error.class)})
    @RequestMapping(value = "/events/{eventId}", produces = {"application/json"}, method = DELETE)
    ResponseEntity deleteEvent(@ApiParam(value = "", required = true) @PathVariable("eventId") Long eventId);

}