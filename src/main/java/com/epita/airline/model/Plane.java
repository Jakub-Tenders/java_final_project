package com.epita.airline.model;

public class Plane {
    private Long idPlane;
    private String brand;
    private String model;
    private int manufacturingYear;

    // Getters and Setters
    public Long getIdPlane() { return idPlane; }
    public void setIdPlane(Long idPlane) { this.idPlane = idPlane; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getManufacturingYear() { return manufacturingYear; }
    public void setManufacturingYear(int manufacturingYear) { this.manufacturingYear = manufacturingYear; }
}
