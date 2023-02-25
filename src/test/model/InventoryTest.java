package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private Inventory testInventory;

    @BeforeEach
    void runBefore() {
        testInventory = new Inventory();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testAddProductOnce() {
        Product p = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        assertTrue(testInventory.addProduct(p));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p, testInventory.getProductByIndex(0));
    }

    @Test
    void testAddProductTwice() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
    }

    @Test
    void testRemoveProductFirstOne() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
        assertTrue(testInventory.removeProduct(p1));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p2, testInventory.getProductByIndex(0));
    }

    @Test
    void testRemoveProductSecondOne() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
        assertTrue(testInventory.removeProduct(p2));
        assertEquals(1, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
    }

    @Test
    void testRemoveProductTwice() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertTrue(testInventory.removeProduct(p2));
        assertTrue(testInventory.removeProduct(p1));
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testRemoveProductDidNotRemoveProduct() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        Product p3 = new Product("Hand Salve", "Kiehl's", "Hand Cream",
                6, LocalDate.of(2023, 7, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertFalse(testInventory.removeProduct(p3));
        assertEquals(2, testInventory.getTotal());
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
    }

    @Test
    void testGetTotalEmpty() {
        assertEquals(0, testInventory.getTotal());
    }

    @Test
    void testGetTotalNotEmpty() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
    }

    @Test
    void testHasProductTrue() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.hasProduct(p1));
    }

    @Test
    void testHasProductFalse() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertFalse(testInventory.hasProduct(p2));
    }

    @Test
    void testGetProductByIndex() {
        Product p1 = new Product("Eau Thermale", "Uriage", "Lip Balm",
                6, LocalDate.of(2023, 6, 28));
        Product p2 = new Product("April Cotton", "W.Dressroom", "Hand Cream",
                6, LocalDate.of(2023, 11, 12));
        assertTrue(testInventory.addProduct(p1));
        assertTrue(testInventory.addProduct(p2));
        assertEquals(2, testInventory.getTotal());
        assertEquals(p1, testInventory.getProductByIndex(0));
        assertEquals(p2, testInventory.getProductByIndex(1));
    }
    
}
