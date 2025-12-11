package com.epita.airline.model;

import java.time.LocalDateTime;

public class MilesReward {
    private int id;
    private int clientId; // foreign key to Client
    private int miles;
    private LocalDateTime earnedDate;

    public MilesReward() {}

    public MilesReward(int id, int clientId, int miles, LocalDateTime earnedDate) {
        this.id = id;
        this.clientId = clientId;
        this.miles = miles;
        this.earnedDate = earnedDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }
    public int getMiles() { return miles; }
    public void setMiles(int miles) { this.miles = miles; }
    public LocalDateTime getEarnedDate() { return earnedDate; }
    public void setEarnedDate(LocalDateTime earnedDate) { this.earnedDate = earnedDate; }
}
