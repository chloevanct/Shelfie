package persistence;

import org.json.JSONObject;

public interface Writable {

    // This interface references code from this repo:
    // Link: https://github.com/stleary/JSON-java
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
