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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averagePerFare, averagePerFare) == 0;
    }
}
