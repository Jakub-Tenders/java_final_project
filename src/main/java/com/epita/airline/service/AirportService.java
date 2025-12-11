package com.epita.airline.service;

import com.epita.airline.dao.AirportDAO;
import com.epita.airline.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportDAO airportDAO;

    public List<Airport> getAll() { return airportDAO.findAll(); }

    public Airport getById(Long id) { return airportDAO.findById(id); }

    public void addAirport(Airport a) { airportDAO.save(a); }

    public void updateAirport(Long id, Airport a) { airportDAO.update(id, a); }

    public void deleteAirport(Long id) { airportDAO.delete(id); }
}
