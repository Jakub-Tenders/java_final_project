package com.epita.airline.dao;

import com.epita.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Flight> flightMapper = (rs, rowNum) -> {
        Flight f = new Flight();
        f.setIdFlight(rs.getLong("id_flight"));
        f.setFlightNumber(rs.getString("flight_number"));
        f.setPlaneId(rs.getLong("plane_id"));
        f.setDepartureAirportId(rs.getLong("departure_airport_id"));
        f.setArrivalAirportId(rs.getLong("arrival_airport_id"));
        f.setDepartureTime(rs.getTimestamp("departure_time").toLocalDateTime());
        f.setArrivalTime(rs.getTimestamp("arrival_time").toLocalDateTime());
        return f;
    };

    public int save(Flight f) {
        return jdbc.update(
            "INSERT INTO flight(flight_number, plane_id, departure_airport_id, arrival_airport_id, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?, ?)",
            f.getFlightNumber(), f.getPlaneId(), f.getDepartureAirportId(),
            f.getArrivalAirportId(), f.getDepartureTime(), f.getArrivalTime()
        );
    }

    public List<Flight> findAll() {
        return jdbc.query("SELECT * FROM flight", flightMapper);
    }

    public Flight findById(Long id) {
        return jdbc.queryForObject(
                "SELECT * FROM flight WHERE id_flight = ?",
                flightMapper,
                id
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM flight WHERE id_flight = ?", id);
    }
}
