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
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Inventory inv = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyInventory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyInventory.json");
        try {
            Inventory inv = reader.read();
            assertEquals(0, inv.getTotal());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralInventory(){
        JsonReader reader = new JsonReader("./data/testReaderGeneralInventory.json");
        try {
            Inventory inv = reader.read();
            List<Product> products = inv.getProducts();
            assertEquals(2, products.size());
            checkProduct(1, "eau thermale","uriage", "lip balm", 6,
                    LocalDate.of(2023,11,28), products.get(0));
            checkProduct(3, "hand salve","kiehls", "hand cream", 6,
                    LocalDate.of(2023,8,30), products.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
