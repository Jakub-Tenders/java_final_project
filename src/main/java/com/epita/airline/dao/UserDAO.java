package com.epita.airline.dao;

import com.epita.airline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User u = new User();
        u.setId(rs.getLong("id"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setAddress(rs.getString("address"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        if (rs.getDate("birthdate") != null) {
            u.setBirthdate(rs.getDate("birthdate").toLocalDate());
        }
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setRole(rs.getString("role"));
        return u;
    };

    public List<User> findAll() {
        return jdbc.query("SELECT * FROM users", userMapper);
    }

    public User findById(Long id) {
        return jdbc.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                userMapper,
                id
        );
    }

    public int save(User u) {
        return jdbc.update(
            "INSERT INTO users (firstname, lastname, address, email, phone, birthdate, username, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            u.getFirstname(),
            u.getLastname(),
            u.getAddress(),
            u.getEmail(),
            u.getPhone(),
            u.getBirthdate(),
            u.getUsername(),
            u.getPassword(),
            u.getRole()
        );
    }

    public int update(Long id, User u) {
        return jdbc.update(
            "UPDATE users SET firstname=?, lastname=?, address=?, email=?, phone=?, birthdate=?, username=?, password=?, role=? WHERE id=?",
            u.getFirstname(),
            u.getLastname(),
            u.getAddress(),
            u.getEmail(),
            u.getPhone(),
            u.getBirthdate(),
            u.getUsername(),
            u.getPassword(),
            u.getRole(),
            id
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM users WHERE id=?", id);
    }
}
