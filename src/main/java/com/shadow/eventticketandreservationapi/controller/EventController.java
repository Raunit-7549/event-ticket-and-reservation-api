package com.shadow.eventticketandreservationapi.controller;

import com.shadow.eventticketandreservationapi.model.Event;
import com.shadow.eventticketandreservationapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @GetMapping("/activeEvents")
    public List<Event> getAllActiveEvents(){
        return service.getAllActiveEvents();
    }
}
