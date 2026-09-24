package com.shadow.eventticketandreservationapi.model;

import java.time.LocalDateTime;

public class Booking {

    private int id;
    private int event_id;
    private String customer_name;
    private String customer_email;
    private int tickets_booked;
    private LocalDateTime booking_time;

    public Booking(){

    }

    public Booking(int id, int event_id, String customer_name, String customer_email, int tickets_booked, LocalDateTime booking_time) {
        this.id = id;
        this.event_id = event_id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.tickets_booked = tickets_booked;
        this.booking_time = booking_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getTickets_booked() {
        return tickets_booked;
    }

    public void setTickets_booked(int tickets_booked) {
        this.tickets_booked = tickets_booked;
    }

    public LocalDateTime getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(LocalDateTime booking_time) {
        this.booking_time = booking_time;
    }
}
