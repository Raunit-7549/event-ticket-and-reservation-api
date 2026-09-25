package com.shadow.eventticketandreservationapi.service;

import com.shadow.eventticketandreservationapi.model.Booking;
import com.shadow.eventticketandreservationapi.model.Event;
import com.shadow.eventticketandreservationapi.repository.BookingRepository;
import com.shadow.eventticketandreservationapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private EventRepository eventRepo;

    @Transactional
    public void createBooking(Booking booking){

        Event event = eventRepo.eventInfo(booking.getEventId());

        if(event == null){
            throw new RuntimeException("Event not found with ID : " + booking.getEventId());
        }

        if(booking.getTicketsBooked() > event.getAvailableSeats()){
            throw new IllegalArgumentException("Not enough tickets available for booking");
        }

        bookingRepo.createBooking(booking);
        eventRepo.decreaseAvailableSeats(booking.getEventId(), booking.getTicketsBooked());
    }

    @Transactional
    public void cancelBooking(int id){

        Booking booking = bookingRepo.bookingInfo(id);
        if(booking == null){
            throw new RuntimeException("Booking with ID : " + id + " does not exist");
        }
        Event event = eventRepo.eventInfo(booking.getEventId());
        if(event == null){
            throw new RuntimeException("Event with ID : " + booking.getEventId() + " does not exist");
        }


        if(!event.getEventDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("The event with ID : " + event.getId() + " is already completed");
        }

        bookingRepo.deleteBooking(id);
        eventRepo.increaseAvailableSeats(event.getId(), booking.getTicketsBooked());
    }

    public Booking getBookingDetails(int id){

        Booking booking = bookingRepo.bookingInfo(id);
        if(booking == null){
            throw new RuntimeException("Booking not found with ID : " + id);
        }

        return booking;
    }

}