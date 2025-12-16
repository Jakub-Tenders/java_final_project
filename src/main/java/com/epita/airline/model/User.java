package com.epita.airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private LocalDate birthdate;
    private String username; 
    private String password;  
    private String role;      
}
