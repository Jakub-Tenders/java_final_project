package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    private Long idAirport;
    private String nameAirport;
    private String countryAirport;
    private String cityAirport;
}
