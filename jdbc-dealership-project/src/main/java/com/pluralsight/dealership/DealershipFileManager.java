package com.pluralsight.dealership;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

//phase 2
public class DealershipFileManager {

    public static Dealership getDealership() {

        try {
            FileInputStream myFileInputStream = new FileInputStream("inventory.csv"); //point to the inventory file
            Scanner myScanner = new Scanner(myFileInputStream); //Scanner to read the line of the file
            String lineFromFile = myScanner.nextLine();// read the first line of the file to get dealership info

            Dealership myDealership = new Dealership(lineFromFile); //Creating the myDealership object and passing the line from file

            while (myScanner.hasNextLine()) { //checking for more line
                lineFromFile = myScanner.nextLine(); //read one line from the file and store it in a string variable
                Vehicle myVehicle = new Vehicle(lineFromFile); //calling a constructor in the Vehicle class which will split the string and parse the parts to get the vehicle details
                myDealership.addVehicle(myVehicle); // add the vehicle object to the inventory of the dealership object
            }
            myScanner.close();
            return myDealership;

        } catch (Exception e) {
            System.out.println("An unexpected error occurred");
            e.printStackTrace();
        }
        return null; //returning null because intelliJ suggested it

    }


    public static void saveDealership(Dealership dealership) {
        try {
            FileWriter myFW = new FileWriter("dealershipInventory.csv");
            // read the first line of the csv, which is a dealership
            myFW.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for(Vehicle v : dealership.getAllVehicles()) {
                myFW.write("\n" + v.getVehicleDetails());
            }
            myFW.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


