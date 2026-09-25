package com.shadow.eventticketandreservationapi.repository;

import com.shadow.eventticketandreservationapi.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BookingRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void createBooking(Booking booking){

        String sql = "insert into bookings (id, event_id, customer_name, customer_email, tickets_booked, booking_time) values(?,?,?,?,?,?)";

        int row = template.update(sql, booking.getId(), booking.getEventId(), booking.getCustomerName(), booking.getCustomerEmail(), booking.getTicketsBooked(), booking.getBookingTime());
    }

    public Booking bookingInfo(int id){

        String sql = "select * from bookings where id=?";

        Booking booking = template.queryForObject(sql, (rs, rowNum) ->{
            Booking b = new Booking();
            b.setId(rs.getInt(1));
            b.setEventId(rs.getInt(2));
            b.setCustomerName(rs.getString(3));
            b.setCustomerEmail(rs.getString(4));
            b.setTicketsBooked(rs.getInt(5));
            b.setBookingTime(rs.getObject(6, LocalDateTime.class));
            return b;
        }, id);

        return booking;
    }

    public List<Booking> bookings(){

        String sql = "select * from bookings";

        List<Booking> bookings = template.query(sql, (rs, rowNum) ->{
            Booking b = new Booking();
            b.setId(rs.getInt(1));
            b.setEventId(rs.getInt(2));
            b.setCustomerName(rs.getString(3));
            b.setCustomerEmail(rs.getString(4));
            b.setTicketsBooked(rs.getInt(5));
            b.setBookingTime(rs.getObject(6, LocalDateTime.class));
            return b;
        });

        return bookings;
    }

    public void updateBooking(Booking booking, int id){

        String sql = "update bookings set event_id=?, customer_name=?, customer_email=?, tickets_booked=?, booking_time=? where id=?";

        template.update(sql, booking.getEventId(), booking.getCustomerName(), booking.getCustomerEmail(), booking.getTicketsBooked(), booking.getBookingTime(), id);
    }

    public void deleteBooking(int id){

        String sql = "delete from bookings where id=?";

        template.update(sql, id);
    }
}
