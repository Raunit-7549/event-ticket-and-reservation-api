package com.shadow.eventticketandreservationapi.model;

import java.time.LocalDate;

public class Event {

    private int id;
    private String title;
    private String venue;
    private LocalDate eventDate;
    private int availableSeats;
    private float ticketPrice;

    public Event(){

    }

    public Event(int id, String title, String venue, LocalDate eventDate, int availableSeats, float ticketPrice) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.eventDate = eventDate;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}