package com.cabinvoice;

public class InvoiceSummary {
    double totalFare;
    int noOfRides;
    double averagePerFare;


    public InvoiceSummary(int length, double totalFare) {
        this.noOfRides=length;
        this.totalFare=totalFare;
        this.averagePerFare=totalFare/noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides &&
                totalFare == that.totalFare &&
                averagePerFare == that.averagePerFare;
    }
}
