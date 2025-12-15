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
import java.util.List;

@Repository
public class BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Booking findById(Integer id) {
        String sql = "SELECT * FROM booking WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Booking b = new Booking();
            b.setId(rs.getInt("id"));
            b.setUserId(rs.getInt("user_id"));
            b.setFlightId(rs.getInt("flight_id"));
            b.setSeatNumber(rs.getString("seat_number"));
            b.setBookingTime(rs.getTimestamp("booking_time").toLocalDateTime());
            return b;
        }, id);
    }

    public List<Booking> findAll() {
        String sql = "SELECT * FROM booking";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Booking b = new Booking();
            b.setId(rs.getInt("id"));
            b.setUserId(rs.getInt("user_id"));
            b.setFlightId(rs.getInt("flight_id"));
            b.setSeatNumber(rs.getString("seat_number"));
            b.setBookingTime(rs.getTimestamp("booking_time").toLocalDateTime());
            return b;
        });
    }

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
