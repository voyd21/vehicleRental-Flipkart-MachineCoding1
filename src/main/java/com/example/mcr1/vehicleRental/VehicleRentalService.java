package com.example.mcr1.vehicleRental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


//the vehicle rental service class,
public class VehicleRentalService {
    private Map<String, Branch> branches;

    VehicleRentalService() {
        this.branches = new HashMap<>();
    }

    public void addBranch(String name, List<String> vehicleInfo) {
        Branch branch = new Branch(name);
        for (String info : vehicleInfo) {
            String[] parts = info.split(" ");
            int count = Integer.parseInt(parts[0]);
            String type = parts[1];
            int pricePerSlot = Integer.parseInt(parts[parts.length - 1]);
            branch.addVehicle(type, count, pricePerSlot);
        }
        branches.put(name, branch);
    }

    public boolean rentVehicle(String type, LocalDateTime startTime, LocalDateTime endTime) {
        for (Branch branch : branches.values()) {
            List<Vehicle> availableVehicles = branch.getAvailableVehicles(type, startTime, endTime);
            if (!availableVehicles.isEmpty()) {
                Vehicle vehicle = availableVehicles.get(0);
                return vehicle.book(startTime, endTime);
            }
        }
        return false;
    }

    public void printSystemViewForTimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        for (Branch branch : branches.values()) {
            System.out.println(branch.getName() + ":");
            for (Map.Entry<String, List<Vehicle>> entry : branch.getVehicles().entrySet()) {
                String type = entry.getKey();
                List<Vehicle> vehicleList = entry.getValue();
                boolean isAvailable = false;
                boolean isBooked = false;
                for (Vehicle vehicle : vehicleList) {
                    if (vehicle.isAvailable(startTime, endTime)) {
                        isAvailable = true;
                    } else {
                        isBooked = true;
                    }
                }
                if (isBooked) {
                    System.out.println("All " + type + " are booked.");
                }
                if (isAvailable) {
                    System.out.println("\t\"" + type + "\" is available for Rs." + vehicleList.get(0).getHourlyPrice());
                }
            }
        }
    }
}

