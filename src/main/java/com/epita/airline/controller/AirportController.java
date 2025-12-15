package com.epita.airline.controller;

import com.epita.airline.model.Airport;
import com.epita.airline.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.getAll();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @PostMapping
    public String createAirport(@RequestBody Airport a) {
        airportService.addAirport(a);
        return "Airport created successfully!";
    }

    @GetMapping("/{id}")
    public Airport getById(@PathVariable Long id) {
        return airportService.getById(id);
    }

    @PutMapping("/{id}")
    public String updateAirport(@PathVariable Long id, @RequestBody Airport a) {
        airportService.updateAirport(id, a);
        return "Airport updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return "Airport deleted successfully!";
    }
}
