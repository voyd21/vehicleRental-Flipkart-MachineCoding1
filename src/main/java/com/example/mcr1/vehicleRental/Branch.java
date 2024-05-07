package com.example.mcr1.vehicleRental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
    private String name;
    private Map<String, List<Vehicle>> vehicles;

    Branch(String name) {
        this.name = name;
        this.vehicles = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void addVehicle(String type, int count, int hourlyPrice) {
        List<Vehicle> vehiclesList = vehicles.getOrDefault(type, new ArrayList<>());
        vehicles.put(type, vehiclesList);

        for (int i = 0; i < count; i++) {
            vehiclesList.add(new Vehicle(type, hourlyPrice));
        }
    }

    public List<Vehicle> getAvailableVehicles(String type, LocalDateTime startTime, LocalDateTime endTime) {
        List<Vehicle> availableVehicle = new ArrayList<>();
        List<Vehicle> vehicleType = vehicles.get(type);

        if (vehicleType != null) {
            for (Vehicle vehicle : vehicleType) {
                if (vehicle.isAvailable(startTime, endTime)) {
                    availableVehicle.add(vehicle);
                }
            }
        }

        return availableVehicle;
    }

}

