package com.cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void init(){
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnFare(){
        Assert.assertEquals(25,invoiceGenerator.calculateFare(2.0,5),0.0);
    }

    @Test
    public void givenMinimumDistanceAndTime_ReturnsMinimumFare(){
        Assert.assertEquals(5,invoiceGenerator.calculateFare(0.1,1),0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(0.1,1)
        };

        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,totalFare,0.0);
    }

    @Test
    public void givenRides_ReturnsInvoiceSummary(){
        Ride[] rides = {
                new Ride(0.1,1),
                new Ride(2.0,5)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFareWithSummary(rides);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(summary, invoiceSummary);
    }

}