package model;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

class ProductTest {
    private Product testProduct;

    @BeforeEach
    void runBefore() {
        testProduct = new Product("Eau Thermale", "Uriage", "Lip Blam", 6,
                LocalDate.of(2023, 6, 28));
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


}