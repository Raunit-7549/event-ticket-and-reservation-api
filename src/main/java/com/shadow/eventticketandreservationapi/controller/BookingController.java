package com.shadow.eventticketandreservationapi.controller;

import com.shadow.eventticketandreservationapi.model.Booking;
import com.shadow.eventticketandreservationapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bookings")
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping
    public void createBooking(@RequestBody Booking booking){
        service.createBooking(booking);
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable int id){
        service.cancelBooking(id);
    }

    @GetMapping("/{id}")
    public Booking getBookingDetails(@PathVariable int id){
        return service.getBookingDetails(id);
    }

}