package ui;

import java.io.FileNotFoundException;

// Run Shelfie application
public class Main {
    public static void main(String[] args) {
        try {
            new ShelfieApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run the application: file not found");
        }
    }

}
