package model;

import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;

// Represents a product having a name, brand, type, period after opening, expiry date, and unique id
public class Product implements Writable {

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

    // REQUIRES: id is unique to product;
    //           product name, brand and type has non-zero length;
    //           periodAfterOpening > 0 month;  and expDate is no earlier than current date.
    // EFFECTS: id, name, brand and type are set to id, name, brand and type;
    //          periodAfterOpening is set to periodAfterOpening;
    //          expDate is set to expDate;
    //          nextProductID is set to next highest unique nextProductID
    public Product(int id, String name, String brand, String type, int periodAfterOpening, LocalDate expDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.periodAfterOpening = periodAfterOpening;
        this.expDate = expDate;
        nextProductId = Math.max(nextProductId, id + 1);
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
    public void updateExpDateOnceOpened() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(periodAfterOpening);
        this.expDate = futureDate;
    }

    public int getID() {
        return id;
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

    public void setPeriodAfterOpening(int periodAfterOpening) {
        this.periodAfterOpening = periodAfterOpening;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }


    @Override
    // EFFECTS: returns a string representation of product
    public String toString() {
        return "[ id = " + id + ", name = " + name + ", brand = " + brand + ", type = " + type
                + ", period after opening = " + periodAfterOpening + ", exp date = " + expDate + " ]";
    }

    @Override
    // EFFECTS: returns product as json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("brand", brand);
        json.put("type", type);
        json.put("period after opening", periodAfterOpening);
        json.put("exp date", expDate);
        return json;
    }

}
