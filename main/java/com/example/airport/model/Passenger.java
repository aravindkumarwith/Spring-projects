package com.example.airport.model;

public class Passenger {
    private String name;
    private String seatCategory;

    // Default constructor
    public Passenger() {
    }

    // Constructor with parameters
    public Passenger(String name, String seatCategory) {
        this.name = name;
        this.seatCategory = seatCategory;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for seatCategory
    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    @Override
    public String toString() {
        return "Passenger{name='" + name + "', seatCategory='" + seatCategory + "'}";
    }
}

