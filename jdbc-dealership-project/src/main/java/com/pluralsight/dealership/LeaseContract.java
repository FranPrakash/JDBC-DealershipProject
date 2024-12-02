package com.pluralsight.dealership;
//Phase 1
public class LeaseContract extends Contract {

    private double expectedEndingValue; //50%original price
    private double leaseFee; //7% original price

//Constructor
    public LeaseContract(String contractDate, String customerEmail, String customerName, double monthlyPayment, double totalPrice, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(contractDate, customerEmail, customerName, monthlyPayment, totalPrice, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    //Getters and Setters
    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    //Override Methods
    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
