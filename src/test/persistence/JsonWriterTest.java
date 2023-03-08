package persistence;

import model.Inventory;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// This class references code from this repo:
// Link: https://github.com/stleary/JSON-java
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Inventory inv = new Inventory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IO Exception was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyInventory() {
        try {
            Inventory inv = new Inventory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInventory.json");
            writer.open();
            writer.write(inv);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInventory.json");
            inv = reader.read();
            assertEquals(0, inv.getTotal());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralInventory() {
        try {
            Inventory inv = new Inventory();
            Product p1 = new Product(3, "efficacer duo", "laroche posay", "lotion",
                    3, LocalDate.of(2025, 02, 28));
            Product p2 = new Product(4, "SA cleanser", "cerave", "face wash",
                    6, LocalDate.of(2023, 10, 30));
            inv.addProduct(p1);
            inv.addProduct(p2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralInventory.json");
            writer.open();
            writer.write(inv);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralInventory.json");
            inv = reader.read();
            List<Product> products = inv.getProducts();
            assertEquals(2, inv.getTotal());
            checkProduct(3, "efficacer duo", "laroche posay", "lotion",
                    3, LocalDate.of(2025, 02, 28), products.get(0));
            checkProduct(4, "SA cleanser", "cerave", "face wash",
                    6, LocalDate.of(2023, 10, 30), products.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
