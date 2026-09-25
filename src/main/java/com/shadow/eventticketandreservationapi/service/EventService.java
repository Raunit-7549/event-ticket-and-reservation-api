package com.shadow.eventticketandreservationapi.service;


import com.shadow.eventticketandreservationapi.model.Event;
import com.shadow.eventticketandreservationapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    public List<Event> getAllActiveEvents(){

        List<Event> events = eventRepo.events();
        LocalDate todayDate = LocalDate.now();

        return events.stream()
                .filter(event-> event.getEventDate() != null)
                .filter(event -> event.getEventDate().isAfter(todayDate))
                .collect(Collectors.toList());
    }

    public Event getEventDetailsByID(int id){
        Event event = eventRepo.eventInfo(id);
        if(event == null){
            throw new RuntimeException("Event not found with ID : " + id);
        }
        return event;
    }

    public List<Event> getEventsByVenue(String venue){

        List<Event> events = eventRepo.events();

        return events.stream().filter(event -> event.getVenue() != null)
                .filter(event -> event.getVenue().equalsIgnoreCase(venue))
                .collect(Collectors.toList());
    }

    public void createEvent(Event event){

        if(event.getEventDate() == null || !event.getEventDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Event date must be in the future");
        }

        if(event.getTicketPrice() < 0){
            throw new IllegalArgumentException("Event price cannot be negative");
        }

        if(event.getAvailableSeats() <= 0){
            throw new IllegalArgumentException("Available seats must be greater than zero");
        }

        eventRepo.createEvent(event);
    }

    public void updateEvent(Event event, int id){

        if(eventRepo.eventInfo(id) == null){
            throw new RuntimeException("Event not found with ID : " + id);
        }

        if(event.getEventDate() == null || !event.getEventDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Event date must be in the future");
        }

        if(event.getTicketPrice() < 0){
            throw new IllegalArgumentException("Event price cannot be negative");
        }

        eventRepo.updateEvent(event, id);
    }

    public void cancelEvent(int id){

        Event event = eventRepo.eventInfo(id);

        if(event == null){
            throw new RuntimeException("Event not found with ID : " + id);
        }

        if(event.getEventDate() == null || !event.getEventDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Event date must be in the future");
        }

        eventRepo.deleteEvent(id);
    }

}
