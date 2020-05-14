package com.cabinvoice;

public class Ride {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    double totalFare=0.0;
    double distance;
    int time;
    boolean isPremium;


    Ride( double distance, int time, boolean ...isPremium){
        this.distance=distance;
        this.time=time;
        if (isPremium.length>0){
            this.isPremium=isPremium[0];
        }
    }

}
