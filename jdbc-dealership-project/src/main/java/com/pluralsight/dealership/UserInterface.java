package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.Scanner;

//phase 3
public class UserInterface {

    private Dealership dealership;

    //Constructor
    public UserInterface() {
    }

    boolean run = true;

    public void display() {
        Scanner myScanner = new Scanner(System.in);
        init();  // Call init method
        do {
            showMenu();
            System.out.println("Choice: ");
            String choice = myScanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    AddVehicleRequest();
                    break;
                case "9":
                    RemoveVehicleRequest();
                    break;
                case "99":
                    run = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose the right option");
            }
        } while (run);

    }

    public void processGetByPriceRequest() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the minimum price?");
        double min = myScanner.nextDouble();
        myScanner.nextLine();
        System.out.println("What is the maximum price?");
        double max = myScanner.nextDouble();
        myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByPrice = this.dealership.getVehiclesByPrice(min, max);
        if (vehiclesByPrice.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByPrice);
    }

    public void processGetByMakeModelRequest() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the Make?");
        String make = myScanner.nextLine();
        System.out.println("What is the Model?");
        String model = myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByMakeModel = this.dealership.getVehiclesByMakeModel(make, model);
        if (vehiclesByMakeModel.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByMakeModel);
    }

    public void processGetByYearRequest() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the minimum year?");
        int min = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("What is the maximum year?");
        int max = myScanner.nextInt();
        myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByYear = this.dealership.getVehiclesByYear(min, max);
        if (vehiclesByYear.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByYear);
    }

    public void processGetByColorRequest() {
        System.out.println("Choose a color to search for vehicles.");
        Scanner myScanner = new Scanner(System.in);
        String colorChoice = myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByColor = this.dealership.getVehiclesByColor(colorChoice);
        if (vehiclesByColor.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByColor);
    }

    public void processGetByMileageRequest() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the minimum miles?");
        int min = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("What is the maximum miles?");
        int max = myScanner.nextInt();
        myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByMileage = this.dealership.getVehiclesByMileage(min, max);
        if (vehiclesByMileage.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByMileage);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Choose the vehicle type to search for vehicles.");
        Scanner myScanner = new Scanner(System.in);
        String vehicleTypeChoice = myScanner.nextLine();
        ArrayList<Vehicle> vehiclesByType = this.dealership.getVehiclesByType(vehicleTypeChoice);
        if (vehiclesByType.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(vehiclesByType);
    }

    public void processGetAllVehiclesRequest() {
        // 1) Call the dealership's getAllVehicles() method
        ArrayList<Vehicle> allVehicles = this.dealership.getAllVehicles();
        // 2) Call the display() helper method
        if (allVehicles.size() == 0)
            System.out.println("No such vehicles found.");
        else
            displayVehicles(allVehicles);
    }

    public void AddVehicleRequest() {
        // get all the data to add a vehicle and create a new vehicle
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter Vin");
        int vin = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Enter Year");
        int year = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Enter Make");
        String make = myScanner.nextLine();
        System.out.println("Enter Model");
        String model = myScanner.nextLine();
        System.out.println("Enter Vehicle type");
        String vehicleType = myScanner.nextLine();
        System.out.println("Enter Color");
        String color = myScanner.nextLine();
        System.out.println("Enter Odometer");
        int odometer = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Enter Price");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        Vehicle vehicle = new Vehicle(color, make, model, odometer, price, vehicleType,vin,year);

        this.dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(this.dealership);
    }

    public void RemoveVehicleRequest() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the vin of vehicle to be removed?");
        int vin = myScanner.nextInt();
        myScanner.nextLine();
        dealership.removeVehicle(vin);
        displayVehicles(this.dealership.getAllVehicles());
        DealershipFileManager.saveDealership(this.dealership);
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    //Helper method to display menu
    private void showMenu() {
        System.out.println("Welcome to Car Dealership!");
        System.out.println("Type 1 to find vehicles within a price range");
        System.out.println("Type 2 to find Vehicles by make/model");
        System.out.println("Type 3 to find vehicles by year range");
        System.out.println("Type 4 to find vehicles by color");
        System.out.println("Type 5 to find vehicles by mileage range");
        System.out.println("Type 6 to find vehicles by type");
        System.out.println("Type 7 to list all vehicles");
        System.out.println("Type 8 to add a vehicle");
        System.out.println("Type 9 to remove a vehicle");
        System.out.println("Type 99 to quit");
    }

    //Display vehicles helper method
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) { // for each vehicle in the list of vehicles execute the code block below
            System.out.print("VIN:" + vehicle.getVin() + ", ");
            System.out.print("Year:" + vehicle.getYear() + ", ");
            System.out.print("Make:" + vehicle.getMake() + ", ");
            System.out.print("Model:" + vehicle.getModel() + " ");
            System.out.print("Vehicle Type:" + vehicle.getVehicleType() + ", ");
            System.out.print("Color:" + vehicle.getColor() + ", ");
            System.out.print("Odometer:" + vehicle.getOdometer() + ", ");
            System.out.println("Price:" + vehicle.getPrice() );

            //  private int vin; // Vehicle Identification Number
            //private int year;
            // private String make;
            // private String model;
            // private String vehicleType;
            //  private String color;
            //  private int odometer;
            //   private double price;


        }
    }

}
