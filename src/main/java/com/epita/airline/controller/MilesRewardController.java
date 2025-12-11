package com.epita.airline.controller;

import com.epita.airline.model.MilesReward;
import com.epita.airline.service.MilesRewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miles-rewards")
public class MilesRewardController {

    private final MilesRewardService milesRewardService;

    public MilesRewardController(MilesRewardService milesRewardService) {
        this.milesRewardService = milesRewardService;
    }

    @PostMapping
    public void createMilesReward(@RequestBody MilesReward milesReward) {
        milesRewardService.addMilesReward(milesReward);
    }

    @GetMapping
    public List<MilesReward> getMilesRewards() {
        return milesRewardService.getAllMilesRewards();
    }
}
