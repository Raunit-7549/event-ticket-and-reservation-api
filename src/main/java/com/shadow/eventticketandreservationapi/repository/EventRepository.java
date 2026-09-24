package com.shadow.eventticketandreservationapi.repository;

import com.shadow.eventticketandreservationapi.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class EventRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void createEvent(Event event){

        String sql = "insert into events (id, title, venue, event_date, available_seats, ticket_price) values(?, ?, ?, ?, ?, ?)";

        int row = template.update(sql, event.getId(), event.getTitle(), event.getVenue(), event.getEvent_date(), event.getAvailable_seats(), event.getTicket_price());
    }

    public Event eventInfo(int id){

        String sql = "select * from events where id=?";

        Event event = template.queryForObject(sql, (rs, rowNum) ->{

            Event e = new Event();
            e.setId(rs.getInt(1));
            e.setTitle(rs.getString(2));
            e.setVenue(rs.getString(3));
            e.setEvent_date(rs.getObject(4, LocalDate.class));
            e.setAvailable_seats(rs.getInt(5));
            e.setTicket_price(rs.getFloat(6));
            return e;

        }, id);

        return event;
    }

    public List<Event> allEvents(){

        String sql = "select * from events";

        List<Event> events = template.query(sql, (rs, rownum) -> {

            Event e = new Event();
            e.setId(rs.getInt(1));
            e.setTitle(rs.getString(2));
            e.setVenue(rs.getString(3));
            e.setEvent_date(rs.getObject(4, LocalDate.class));
            e.setAvailable_seats(rs.getInt(5));
            e.setTicket_price(rs.getFloat(6));
            return e;
        });

        return events;
    }

    public void updateEvent(Event e){

        String sql = "update events set title=?, venue=?, event_date=?, available_seats=?, ticket_price=? where id=?";

        template.update(sql, e.getTitle(), e.getVenue(), e.getEvent_date(), e.getAvailable_seats(), e.getTicket_price(), e.getId());
    }

    public void deleteEvent(int id){

        String sql = "delete from events where id=?";

        template.update(sql, id);
    }
}