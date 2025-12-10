package com.epita.airline.dao;

import com.epita.airline.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaneDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Plane> planeMapper = (rs, rowNum) -> {
        Plane p = new Plane();
        p.setIdPlane(rs.getLong("id_plane"));
        p.setBrand(rs.getString("brand"));
        p.setModel(rs.getString("model"));
        p.setManufacturingYear(rs.getInt("manufacturing_year"));
        return p;
    };

    public List<Plane> findAll() {
        return jdbc.query("SELECT * FROM plane", planeMapper);
    }

    public Plane findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM plane WHERE id_plane=?", planeMapper, id);
    }

    public int save(Plane p) {
        return jdbc.update(
            "INSERT INTO plane(brand, model, manufacturing_year) VALUES (?, ?, ?)",
            p.getBrand(), p.getModel(), p.getManufacturingYear()
        );
    }

    public int update(Long id, Plane p) {
        return jdbc.update(
            "UPDATE plane SET brand=?, model=?, manufacturing_year=? WHERE id_plane=?",
            p.getBrand(), p.getModel(), p.getManufacturingYear(), id
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM plane WHERE id_plane=?", id);
    }
}
