package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long idBooking;
    private String lastname;
    private String firstname;
    private String passportNumber;
    private LocalDate birthdate;
    private Long flightId;
}
