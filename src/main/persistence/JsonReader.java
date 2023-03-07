package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import model.Inventory;
import model.Product;
import org.json.*;

// Represents a reader that reads Inventory from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from the source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads inventory from file and returns it;
    // throws IOException if an error occurs while reading data from file
    public Inventory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseInventory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses inventory from JSON object and returns it
    private Inventory parseInventory(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Inventory inv = new Inventory();
        addProducts(inv, jsonObject);
        return inv;
    }

    // MODIFIES: inv
    // EFFECTS: parses products from JSON object and adds them to inventory
    private void addProducts(Inventory inv, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("product");
        for (Object json : jsonArray) {
            JSONObject nextProduct = (JSONObject) json;
            addProduct(inv, nextProduct);
        }
    }

    // MODIFIES: inv
    // EFFECTS: parses product from JSON object and adds it to inventory
    private void addProduct(Inventory inv, JSONObject jsonObject) {
        int id = Integer.valueOf(jsonObject.getString("id"));
        String name = jsonObject.getString("name");
        String brand = jsonObject.getString("brand");
        String type = jsonObject.getString("type");
        int periodAfterOpening = Integer.valueOf(jsonObject.getString("period after opening"));
        LocalDate expDate = LocalDate.parse(jsonObject.getString("exp date"));
        Product product = new Product(name, brand, type, periodAfterOpening, expDate);
        inv.addProduct(product);
    }



}
