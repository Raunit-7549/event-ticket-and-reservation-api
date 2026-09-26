package com.shadow.eventticketandreservationapi.controller;

import com.shadow.eventticketandreservationapi.model.Event;
import com.shadow.eventticketandreservationapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    EventService service;

    @GetMapping
    public List<Event> getAllActiveEvents(){
        return service.getAllActiveEvents();
    }

    @GetMapping("/{id}")
    public Event getEventDetailsByID(@PathVariable int id){
        return service.getEventDetailsByID(id);
    }

    @GetMapping("/venue/{venue}")
    public List<Event> getEventDetailsByID(@PathVariable String venue){
        return service.getEventsByVenue(venue);
    }

    @PostMapping
    public void createEvent(@RequestBody Event event){
        service.createEvent(event);
    }

    @PutMapping("/{id}")
    public void updateEvent(@RequestBody Event event, @PathVariable int id){
        service.updateEvent(event, id);
    }

    @DeleteMapping("/{id}")
    public void cancelEvent(@PathVariable int id){
        service.cancelEvent(id);
    }

}
