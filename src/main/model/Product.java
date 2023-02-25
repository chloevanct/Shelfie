package model;

import java.time.LocalDate;


// Represents a product having a name, brand, type, date purchased, date opened, expiry date, and ID
public class Product {

    private static int nextProductId = 1;
    private int id;
    private String name;
    private String brand;
    private String type;
    private Date purchaseDate;
    private int periodAfterOpening;
    private Date expDate;

    // REQUIRES: product name, brand, type, purchaseDate, periodAfterOpening and expDate if known
    // EFFECTS: constructs a product with name, brand, type, purchase date and period after opening,
    //          has a Date or null expDate if not known.
    //          has an account id which is a positive integer that is unique to each product.
    public Product(String name, String brand, String type, Date purchaseDate, int periodAfterOpening, Date expDate) {
        id = nextProductId++;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.purchaseDate = purchaseDate;
        this.periodAfterOpening = periodAfterOpening;
        this.expDate = expDate;
    }

    //or should I use overloading? period after opening -1, check if null, or choose default value

    // MODIFIES: this
    // EFFECTS: add expiry date
    public Product updateExpDate() {
        return new Product("A", "B", "Cream", );   // stub
    }

    // REQUIRES: product has expiry date or product has period after opening
    // EFFECTS: returns true if product is expired, false if not
    public boolean isExpired() {
        return true;    // stub
    }

    // Getters
    // EFFECTS: returns product name
    public String getName() {
        return name;
    }

    // EFFECTS: returns product brand
    public String getBrand() {
        return brand;
    }

    // EFFECTS: returns expiry date
    public Date getExpDate() {
        return expDate;
    }

}
