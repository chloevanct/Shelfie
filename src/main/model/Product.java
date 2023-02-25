package model;

import java.time.LocalDate;

// Represents a product having a name, brand, type, date purchased, date opened, expiry date, and ID
public class Product {

    private static int nextProductId = 1;
    private int id;
    private String name;
    private String brand;
    private String type;
    private int periodAfterOpening; // number of months
    private LocalDate expDate;

    // REQUIRES: product name, brand and type has non-zero length;
    //           periodAfterOpening > 0;  and expDate is no earlier than current date.
    // EFFECTS: name, brand and type are set to name, brand and type;
    //          periodAfterOpening is set to periodAfterOpening;
    //          expDate is set to expDate;
    //          product id is a positive integer not assigned to any other product.

    public Product(String name, String brand, String type, int periodAfterOpening, LocalDate expDate) {
        id = nextProductId++;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.periodAfterOpening = periodAfterOpening;
        this.expDate = expDate;
    }

    // EFFECTS: returns true if product is expired based on current date, false if not
    public boolean isExpired() {
        return true;    // stub
    }

    // MODIFIES: this
    // EFFECTS: changes expDate to current date + periodAfterOpening
    public void updateExpDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(periodAfterOpening);
        this.expDate = futureDate;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getPeriodAfterOpening() {
        return periodAfterOpening;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

}
