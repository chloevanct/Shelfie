package model;

import java.time.LocalDate;

// Represents a product having a name, brand, type, period after opening, expiry date, and unique id
public class Product {

    private static int nextProductId = 1;
    private int id;
    private String name;
    private String brand;
    private String type;
    private int periodAfterOpening; // int is number of months
    private LocalDate expDate;

    // REQUIRES: product name, brand and type has non-zero length;
    //           periodAfterOpening > 0 month;  and expDate is no earlier than current date.
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

    // EFFECTS: returns true if expDate is equal or before current date, false if not
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        if (expDate.isBefore(currentDate) || expDate.isEqual(currentDate)) {
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: changes expDate to current date + periodAfterOpening
    public void updateExpDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(periodAfterOpening);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPeriodAfterOpening(int periodAfterOpening) {
        this.periodAfterOpening = periodAfterOpening;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    // EFFECTS: returns a string representation of product
    @Override
    public String toString() {
        return "[ id = " + id + ", name = " + name + ", brand = " + brand + ", type =  " + type
               + ", period after opening = " + periodAfterOpening + ", exp date = " + expDate + " ]";
    }

}
