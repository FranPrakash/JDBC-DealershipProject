package com.pluralsight.dealership;

public class SalesContract extends Contract {

    //TODO: finish Phase 1 Contract
    public static double salesTaxAmount;
    private final double RECORDING_FEE = 100;
    private double processingFee;
    private boolean isFinanced;

    //Super Constructor
    public SalesContract(String contractDate, String customerEmail, String customerName, double monthlyPayment, double totalPrice, Vehicle vehicleSold, boolean isFinanced, double processingFee, double salesTaxAmount) {
        super(contractDate, customerEmail, customerName, monthlyPayment, totalPrice, vehicleSold);
        this.isFinanced = isFinanced;
        this.processingFee = processingFee;
        this.salesTaxAmount = salesTaxAmount;
    }

    //Getters and Setters
    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getRECORDING_FEE() {
        return RECORDING_FEE;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    //TODO: Override methods
    @Override
    public double getMonthlyPayment() {
        // (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
        double p = getTotalPrice();
        double r; // interest rate expressed as monthly
        int n;  // loan term in months
        Vehicle myVehicle = getVehicleSold();
        if (myVehicle.getPrice() < 10000) {
            r = 0.0425 / 12;
            n = 48;
        } else {
            r = 0.0525 / 12;
            n = 24;
        }
        return (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));
    }

    @Override
    public double getTotalPrice() {
        Vehicle myVehicle = getVehicleSold();  // get the vehicle associated with the contract in an object variable for getting the vehicle price in next lines
        setSalesTaxAmount(myVehicle.getPrice() * 0.05);
        if (myVehicle.getPrice() < 10000) setProcessingFee(295);
        else setProcessingFee(495);
        return myVehicle.getPrice() + salesTaxAmount + RECORDING_FEE + processingFee;
    }
}

// A sales contract object is also a contract object
// A contract object has a Vehicle object as a attribute
// we can access this vehicle object and call the getters to get vehicle details.