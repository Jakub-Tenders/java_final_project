package com.epita.airline.service;

import com.epita.airline.dao.FlightDAO;
import com.epita.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightDAO flightDAO;

    public String addFlight(Flight f) {
        flightDAO.save(f);
        return "Flight created successfully";
    }

    public List<Flight> getAllFlights() {
        return flightDAO.findAll();
    }

    public Flight getFlight(Long id) {
        return flightDAO.findById(id);
    }

    public String deleteFlight(Long id) {
        flightDAO.delete(id);
        return "Flight deleted successfully";
    }
}
