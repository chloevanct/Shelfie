package ui;

import java.io.FileNotFoundException;

// This class references code from this repo:
// Link: https://github.com/stleary/JSON-java
// Run Shelfie application
public class Main {
    public static void main(String[] args) {
        try {
            new MainMenuUI();
//            new ShelfieApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run the application: file not found");
        }
    }

}
