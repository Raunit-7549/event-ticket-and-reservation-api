package com.shadow.eventticketandreservationapi.model;

import java.time.LocalDateTime;

public class Booking {

    private int id;
    private int eventId;
    private String customerName;
    private String customerEmail;
    private int ticketsBooked;
    private LocalDateTime bookingTime;

    public Booking(){

    }

    public Booking(int id, int eventId, String customerName, String customerEmail, int ticketsBooked, LocalDateTime bookingTime) {
        this.id = id;
        this.eventId = eventId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.ticketsBooked = ticketsBooked;
        this.bookingTime = bookingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getTicketsBooked() {
        return ticketsBooked;
    }

    public void setTicketsBooked(int ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
