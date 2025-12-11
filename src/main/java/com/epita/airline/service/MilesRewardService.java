package com.epita.airline.service;

import com.epita.airline.dao.MilesRewardDAO;
import com.epita.airline.model.MilesReward;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilesRewardService {

    private final MilesRewardDAO milesRewardDAO;

    public MilesRewardService(MilesRewardDAO milesRewardDAO) {
        this.milesRewardDAO = milesRewardDAO;
    }

    public void addMilesReward(MilesReward milesReward) {
        milesRewardDAO.save(milesReward);
    }

    public List<MilesReward> getAllMilesRewards() {
        return milesRewardDAO.findAll();
    }
}
