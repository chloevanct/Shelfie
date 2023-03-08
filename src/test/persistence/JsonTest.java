package persistence;


import model.Product;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This class references code from this repo:
// Link: https://github.com/stleary/JSON-java
public class JsonTest {
    protected void checkProduct(int id, String name, String brand, String type,
                                int periodAfterOpening, LocalDate expDate, Product p) {
        assertEquals(id, p.getID());
        assertEquals(name, p.getName());
        assertEquals(brand, p.getBrand());
        assertEquals(type, p.getType());
        assertEquals(periodAfterOpening, p.getPeriodAfterOpening());
        assertEquals(expDate, p.getExpDate());
    }
}
