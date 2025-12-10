package com.epita.airline.service;

import com.epita.airline.dao.PlaneDAO;
import com.epita.airline.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    @Autowired
    private PlaneDAO planeDAO;

    public List<Plane> getAllPlanes() {
        return planeDAO.findAll();
    }

    public Plane getPlaneById(Long id) {
        return planeDAO.findById(id);
    }

    public void addPlane(Plane plane) {
        planeDAO.save(plane);
    }

    public void updatePlane(Long id, Plane plane) {
        planeDAO.update(id, plane);
    }

    public void deletePlane(Long id) {
        planeDAO.delete(id);
    }
}
