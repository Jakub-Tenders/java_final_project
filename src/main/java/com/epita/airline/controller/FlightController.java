package com.epita.airline.controller;

import com.epita.airline.model.Flight;
import com.epita.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping
    public String createFlight(@RequestBody Flight f) {
        return service.addFlight(f);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return service.getFlight(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        return service.deleteFlight(id);
    }
}
