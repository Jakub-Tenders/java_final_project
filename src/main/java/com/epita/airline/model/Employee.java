package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long numEmp;
    private String profession;
    private String title;
    private Long idUser; // Foreign key to User
}
