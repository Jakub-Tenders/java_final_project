package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private Long idFlight;
    private Long planeId;         // foreign key to Plane
    private Long departureAirport; // foreign key to Airport
    private Long arrivalAirport;   // foreign key to Airport
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
