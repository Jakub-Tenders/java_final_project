package com.epita.airline.dao;

import com.epita.airline.model.MilesReward;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MilesRewardDAO {

    private final JdbcTemplate jdbcTemplate;

    public MilesRewardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(MilesReward milesReward) {
        String sql = "INSERT INTO miles_reward(client_id, miles, earned_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, milesReward.getClientId(), milesReward.getMiles(), 
            java.sql.Timestamp.valueOf(milesReward.getEarnedDate()));
    }

    public List<MilesReward> findAll() {
        return jdbcTemplate.query("SELECT * FROM miles_reward", new RowMapper<MilesReward>() {
            @Override
            public MilesReward mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new MilesReward(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("miles"),
                        rs.getTimestamp("earned_date").toLocalDateTime()
                );
            }
        });
    }
}
