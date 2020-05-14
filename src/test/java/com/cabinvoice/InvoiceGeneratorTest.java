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
    public void testPasses_WhenGivenDistanceAndTime_ShouldReturnFare(){
        Assert.assertEquals(25,invoiceGenerator.calculateFare(2.0,5),0.0);
    }

    @Test
    public void testPasses_WhenGivenMinimumDistanceAndTime_ReturnsMinimumFare(){
        Assert.assertEquals(5,invoiceGenerator.calculateFare(0.1,1),0.0);
    }

    @Test
    public void testPasses_WhenGivenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(0.1,1)
        };

        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,totalFare,0.0);
    }

    @Test
    public void testPasses_WhenGivenRides_ReturnsInvoiceSummary(){
        Ride[] rides = {
                new Ride(0.1,1),
                new Ride(2.0,5)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFareWithSummary(rides);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary, invoiceSummary);
    }

    @Test
    public void testPasses_WhenGivenUserId_ReturnsInvoiceSummary(){
        String userId="xyz";
        Ride[] rides = {
                new Ride(0.1,1),
                new Ride(2.0,5)
        };
        invoiceGenerator.addUser(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary,expectedSummary);
    }

    @Test
    public void testPasses_ForGivenSameUserId_ReturnsInvoiceSummary(){
        String userId="xyz";
        Ride[] rides = {
                new Ride(2.0,5)
        };
        Ride[] rides1 = {
                new Ride(0.1,1),
                new Ride(2.0,5)
        };
        invoiceGenerator.addUser(userId,rides1);
        invoiceGenerator.addUser(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(3,55);
        Assert.assertEquals(summary,expectedSummary);
    }


    @Test
    public void testPasses_ForPremiumRide(){
        String userId="xyz";
        Ride[] rides = {
                new Ride(3,3,true)
        };
        invoiceGenerator.addUser(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(1,51.0);
        Assert.assertEquals(summary,expectedSummary);
    }

    @Test
    public void testPasses_ForPremiumMinimumCost(){
        String userId="xyz";
        Ride[] rides = {
                new Ride(0.1,1,true)
        };
        invoiceGenerator.addUser(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(1,20.0);
        Assert.assertEquals(summary,expectedSummary);
    }

}
