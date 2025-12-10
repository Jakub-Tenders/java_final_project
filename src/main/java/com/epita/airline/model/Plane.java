package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {
    private Long idPlane;
    private String brand;
    private String model;
    private int manufacturingYear;
}
