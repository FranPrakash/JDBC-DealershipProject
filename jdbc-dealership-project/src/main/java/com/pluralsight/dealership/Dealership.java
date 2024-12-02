package com.pluralsight.dealership;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    //Constructor
    public Dealership(String address, String name, String phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        // instantiate the arrayList<Vehicle> object in the constructor
        this.inventory = new ArrayList<Vehicle>();
    }

    //Constructor for phase 2 - Split the line
    public Dealership(String fileInput) {
        String[] parts = fileInput.split("\\|");
        this.name = parts[0]; //this.name = Integer.parseInt(0)
        this.address = parts[1];
        this.phone = parts[2];
// instantiate the arrayList<Vehicle> object in the constructor
        this.inventory = new ArrayList<Vehicle>(); //Store vehicles
    }

    //getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //End getter and setters

    //Dealership Methods

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max)
                vehiclesByPrice.add(vehicle);
        }
        return vehiclesByPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model))
                vehiclesByMakeModel.add(vehicle);
        }
        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max)
                vehiclesByYear.add(vehicle);
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getColor().equals(color))
                vehiclesByColor.add(vehicle);
        }
        return vehiclesByColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(double min, double max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
                vehiclesByMileage.add(vehicle);
        }
        return vehiclesByMileage;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equals(vehicleType))
                vehiclesByType.add(vehicle);
        }
        return vehiclesByType;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory; //Return this inventory because it holds rge list off all vehicles
    }

    //Stub method
    public void addVehicle(Vehicle myVehicle) {
        this.inventory.add(myVehicle);
    }

    //Stub method a method declaration with empty body between curly braces
    public void removeVehicle(int vin) {
        inventory.removeIf(v -> v.getVin() == vin);
    }
}