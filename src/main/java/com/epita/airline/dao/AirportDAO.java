package com.epita.airline.dao;

import com.epita.airline.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Airport> mapper = (rs, rowNum) -> {
        Airport a = new Airport();
        a.setIdAirport(rs.getLong("id_airport"));
        a.setName(rs.getString("name"));
        a.setCity(rs.getString("city"));
        a.setCountry(rs.getString("country"));
        a.setIataCode(rs.getString("iata_code"));
        return a;
    };

    public List<Airport> findAll() {
        return jdbc.query("SELECT * FROM airport", mapper);
    }

    public Airport findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM airport WHERE id_airport = ?", mapper, id);
    }

    public int save(Airport a) {
        return jdbc.update(
                "INSERT INTO airport(name, city, country, iata_code) VALUES (?, ?, ?, ?)",
                a.getName(), a.getCity(), a.getCountry(), a.getIataCode()
        );
    }

    public int update(Long id, Airport a) {
        return jdbc.update(
                "UPDATE airport SET name=?, city=?, country=?, iata_code=? WHERE id_airport=?",
                a.getName(), a.getCity(), a.getCountry(), a.getIataCode(), id
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM airport WHERE id_airport=?", id);
    }
}
