package com.pluralsight.dealership;
import java.io.FileWriter;
import java.io.IOException;

//phase2 utility class to deal with contracts file.
public class ContractDataManager {

    public static void saveContract(Contract mycontract) {
        try {
            FileWriter myFW = new FileWriter("contracts.csv");
            // The
            myFW.write("\n");  // write the contract details in the correct format per the file template provided
            myFW.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

//TODO: use instaceof to check the type of contract.

// entry to write to the file order separated by pipe character
/*
SALE or LEASE
contract date
customer name
customer email
vin
year
make
model
vehicle type
color
odometer
price
salesTaxAmount
recordingFee
processingFee
totalPrice
is Financed?
Monthly Payment
 */

//git commit -am
//--force

// how to undo a commit?
//git stash