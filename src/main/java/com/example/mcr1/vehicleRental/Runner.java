package com.example.mcr1.vehicleRental;

import java.time.LocalDateTime;
import java.util.List;

public class Runner {


    public static void main(String[] args) {


        VehicleRentalService service = new VehicleRentalService();

        service.addBranch("koramangala", List.of("1 suv 120", "3 sedan 100", "3 bike 200"));
        service.addBranch("jayanagar", List.of("3 sedan 110", "3 bike 300", "4 hatchback 80"));
        service.addBranch("malleshwaram", List.of("1 suv 110", "10 bike 30", "3 sedan 100"));

        service.rentVehicle("suv", LocalDateTime.of(2024, 2, 20, 10, 0),
                LocalDateTime.of(2024, 2, 20, 12, 0));
        service.rentVehicle("suv", LocalDateTime.of(2024, 2, 20, 10, 0),
                LocalDateTime.of(2024, 2, 20, 12, 0));

        service.printSystemViewForTimeSlot(LocalDateTime.of(2024, 2, 20, 11, 0),
                LocalDateTime.of(2024, 2, 20, 12, 0));
    }
    }

