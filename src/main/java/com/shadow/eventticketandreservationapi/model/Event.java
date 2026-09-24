package com.shadow.eventticketandreservationapi.model;

import java.time.LocalDate;

public class Event {

    private int id;
    private String title;
    private String venue;
    private LocalDate event_date;
    private int available_seats;
    private float ticket_price;

    public Event(){

    }

    public Event(int id, String title, String venue, LocalDate event_date, int available_seats, float ticket_price) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.event_date = event_date;
        this.available_seats = available_seats;
        this.ticket_price = ticket_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

}