package com.epita.airline.controller;

import com.epita.airline.model.Plane;
import com.epita.airline.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public Plane getPlane(@PathVariable Long id) {
        return planeService.getPlaneById(id);
    }

    @PostMapping
    public String createPlane(@RequestBody Plane plane) {
        planeService.addPlane(plane);
        return "Plane created successfully";
    }

    @PutMapping("/{id}")
    public String updatePlane(@PathVariable Long id, @RequestBody Plane plane) {
        planeService.updatePlane(id, plane);
        return "Plane updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return "Plane deleted successfully";
    }
}
