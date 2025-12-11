package com.epita.airline.model;

import java.time.LocalDateTime;

public class Booking {
    private Integer id;
    private Integer userId;
    private Integer flightId;
    private String seatNumber;
    private LocalDateTime bookingTime;

    public Booking() {
        this.bookingTime = LocalDateTime.now();
    }

    public Booking(Integer userId, Integer flightId, String seatNumber, LocalDateTime bookingTime) {
        this.userId = userId;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.bookingTime = (bookingTime != null) ? bookingTime : LocalDateTime.now();
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getFlightId() { return flightId; }
    public void setFlightId(Integer flightId) { this.flightId = flightId; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
}
