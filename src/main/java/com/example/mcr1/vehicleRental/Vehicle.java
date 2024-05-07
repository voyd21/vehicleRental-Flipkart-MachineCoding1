package com.example.mcr1.vehicleRental;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehicle {

    private String type;
    private int hourlyPrice;
    private boolean isBooked;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;

    public Vehicle(String type, int hourlyPrice) {
        this.type = type;
        this.hourlyPrice = hourlyPrice;
    }

    public boolean book(LocalDateTime start, LocalDateTime end) {
        if (isBooked) {
            return false;
        } else {
            isBooked = true;
            bookingStart = start;
            bookingEnd = end;
            return true;
        }
    }

    public boolean isAvailable(LocalDateTime startTime, LocalDateTime endTime) {
        if (!isBooked) {
            return true;
        }
        return startTime.isAfter(bookingEnd) || endTime.isBefore(bookingStart);
    }

    public String getType() {
        return type;
    }

    public int getHourlyPrice() {
        return hourlyPrice;
    }
}
