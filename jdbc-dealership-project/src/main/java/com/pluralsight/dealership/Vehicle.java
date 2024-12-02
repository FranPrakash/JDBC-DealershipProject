package com.pluralsight.dealership;

public class Vehicle {

    private int vin; // Vehicle Identification Number
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    //Constructor
    public Vehicle(String color, String make, String model, int odometer, double price, String vehicleType, int vin, int year) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        this.price = price;
        this.vehicleType = vehicleType;
        this.vin = vin;
        this.year = year;
    }

    //Constructor phase 2
    public Vehicle(String fileInput) {
        String[] parts = fileInput.split("\\|");
        this.vin = Integer.parseInt(parts[6]);   //sintax this.name = Integer.parseInt(0)
        this.year = Integer.parseInt(parts[1]);
        this.make = parts[2];
        this.model = parts[3];
        this.vehicleType = parts[4];
        this.color = parts[5];
        this.odometer = Integer.parseInt(parts[0]);
        this.price = Double.parseDouble(parts[7]);

    }


    //Getters and Setters
    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVehicleDetails(){
        return  vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price;
    }
}
