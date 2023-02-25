package model;

import java.time.LocalDate;

// Represents a date with year, month (int), and date
public class Date {

    private int year;
    private int month;
    private int day;

    LocalDate date = LocalDate.of(year, month, day);
}
