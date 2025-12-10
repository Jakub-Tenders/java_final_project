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
        u.setIdUser(rs.getLong("id_user"));
        u.setFirstname(rs.getString("firstname"));
        u.setLastname(rs.getString("lastname"));
        u.setAddress(rs.getString("address"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return u;
    };

    public List<User> findAll() {
        return jdbc.query("SELECT * FROM users", userMapper);
    }

    public User findById(Long id) {
        return jdbc.queryForObject(
                "SELECT * FROM users WHERE id_user = ?",
                userMapper,
                id
        );
    }

    public int save(User u) {
        return jdbc.update("INSERT INTO users(firstname, lastname, address, email, phone, birthdate) VALUES (?, ?, ?, ?, ?, ?)",
                u.getFirstname(), u.getLastname(), u.getAddress(), u.getEmail(), u.getPhone(), u.getBirthdate());
    }

    public int update(Long id, User u) {
        return jdbc.update("UPDATE users SET firstname=?, lastname=?, address=?, email=?, phone=?, birthdate=? WHERE id_user=?",
                u.getFirstname(), u.getLastname(), u.getAddress(),
                u.getEmail(), u.getPhone(), u.getBirthdate(), id);
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM users WHERE id_user=?", id);
    }
}
