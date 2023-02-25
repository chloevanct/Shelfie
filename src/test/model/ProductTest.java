package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product testProduct;

    @BeforeEach
    void runBefore() {
        testProduct = new Product("Eau Thermale", "Uriage", "Lip Balm", 6,
                LocalDate.of(2023, 6, 28));
    }

    @Test
    void testConstructor() {
        assertEquals("Eau Thermale", testProduct.getName());
        assertEquals("Uriage", testProduct.getBrand());
        assertEquals("Lip Balm", testProduct.getType());
        assertEquals(6, testProduct.getPeriodAfterOpening());
        assertEquals(LocalDate.of(2023,6,28), testProduct.getExpDate());
    }

    @Test
    void testIsExpiredJustExpired() {
        testProduct.setExpDate(LocalDate.now());
        assertTrue(testProduct.isExpired());
    }

    @Test
    void testIsExpired() {
        testProduct.setExpDate(LocalDate.of(2020, 6, 28));
        assertTrue(testProduct.isExpired());
    }

    @Test
    void testIsExpiredNotExpired() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(1);
        testProduct.setExpDate(futureDate);
        assertFalse(testProduct.isExpired());
    }

    // MODIFIES: this
    // EFFECTS: changes expDate to current date + periodAfterOpening
    @Test
    void testUpdateExpDateOneMonth() {
        assertEquals(LocalDate.of(2023, 6, 28), testProduct.getExpDate());
        testProduct.setPeriodAfterOpening(1);
        assertEquals(1, testProduct.getPeriodAfterOpening());
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(testProduct.getPeriodAfterOpening());
        testProduct.setExpDate(futureDate);
        assertEquals(futureDate, testProduct.getExpDate());
    }

    @Test
    void testUpdateExpDateSixMonths() {
        assertEquals(LocalDate.of(2023, 6, 28), testProduct.getExpDate());
        assertEquals(6, testProduct.getPeriodAfterOpening());
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusMonths(testProduct.getPeriodAfterOpening());
        testProduct.setExpDate(futureDate);
        assertEquals(futureDate, testProduct.getExpDate());
    }

}