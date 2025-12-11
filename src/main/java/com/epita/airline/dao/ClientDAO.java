package com.epita.airline.dao;

import com.epita.airline.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Client client) {
        String sql = "INSERT INTO client(first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhone());
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM client", new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Client(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"));
            }
        });
    }
}
