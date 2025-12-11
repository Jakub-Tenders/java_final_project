package com.epita.airline.model;

public class Airport {

    private Long idAirport;
    private String name;
    private String city;
    private String country;
    private String iataCode;

    public Long getIdAirport() { return idAirport; }
    public void setIdAirport(Long idAirport) { this.idAirport = idAirport; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getIataCode() { return iataCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }
}
