package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilesReward {
    private Long idReward;
    private String passportNumber; 
    private int flightsThisYear;
    private String discountCode;    
}
