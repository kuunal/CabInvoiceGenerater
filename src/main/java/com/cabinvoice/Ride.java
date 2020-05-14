package com.cabinvoice;

public class Ride {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    double totalFare=0.0;
    double distance;
    int time;


    Ride( double distance, int time){
        this.distance=distance;
        this.time=time;
    }

}
