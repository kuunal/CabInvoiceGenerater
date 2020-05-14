package com.cabinvoice;

public class InvoiceGenerator {
        private static final int costPerKilometer = 10;
        private static final int costPerMinute = 1;

        public double calculateFare(double distance, int time) {
            return costPerKilometer*distance+time*costPerMinute;
    }

}
