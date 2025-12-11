package com.epita.airline.dao;

import com.epita.airline.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
public class BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Booking save(Booking booking) {
        String sql = "INSERT INTO booking(user_id, flight_id, seat_number, booking_time) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setInt(1, booking.getUserId());
                ps.setInt(2, booking.getFlightId());
                ps.setString(3, booking.getSeatNumber());
                ps.setTimestamp(4, Timestamp.valueOf(
                        (booking.getBookingTime() != null) ? booking.getBookingTime() : java.time.LocalDateTime.now()
                ));
                return ps;
            }
        }, keyHolder);

        booking.setId(keyHolder.getKey().intValue());
        return booking;
    }
}
