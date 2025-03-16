package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.Vehicles.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.services.MasterVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Lógica para manejo de solicitudes HTTP Para los tipos de vehículos de tipo Car
 * Extiende la clase abstracta VehicleServiceImpl
 */


@Service
public class CarServices extends VehicleServiceImpl<Car> {

    private final List<Car> cars = new ArrayList<>();

    public CarServices() {
        vehicles = new ArrayList<>();
        vehicles.add(new Car("Civic", "Honda", 2021, "CAML123", 20000.0, Availability.FOR_SALE, 1000, UsedState.NEW, 4));
        vehicles.add(new Car("Corolla", "Toyota", 2020, "ABC123", 25000.0, Availability.SOLD, 5000, UsedState.USED, 4));
        vehicles.add(new Car("Model 3", "Tesla", 2023, "TESL123", 45000.0, Availability.FOR_SALE, 12000, UsedState.USED, 4));
        vehicles.add(new Car("Mustang", "Ford", 2022, "FOR123", 60000.0, Availability.FOR_SALE, 3000, UsedState.NEW, 2));
        vehicles.add(new Car("Accord", "Honda", 2019, "HON456", 22000.0, Availability.SOLD, 20000, UsedState.SEMIUSED, 4));
        vehicles.add(new Car("Camry", "Toyota", 2021, "TOY789", 28000.0, Availability.FOR_SALE, 10000, UsedState.USED, 4));
        vehicles.add(new Car("Challenger", "Dodge", 2022, "DOD123", 55000.0, Availability.SOLD, 1500, UsedState.NEW, 2));
        vehicles.add(new Car("Elantra", "Hyundai", 2020, "HYU321", 20000.0, Availability.PROCESSING, 18000, UsedState.USED, 4));
        vehicles.add(new Car("A4", "Audi", 2021, "AUD987", 38000.0, Availability.PROCESSING, 15000, UsedState.USED, 4));
        vehicles.add(new Car("Series 3", "BMW", 2022, "BMW567", 42000.0, Availability.PROCESSING, 12000, UsedState.SEMIUSED, 4));
        vehicles.add(new Car("Model X", "Tesla", 2023, "TESL789", 90000.0, Availability.SOLD, 6000, UsedState.USED, 4));
        vehicles.add(new Car("Outback", "Subaru", 2021, "SUB888", 31000.0, Availability.PROCESSING, 17000, UsedState.USED, 4));
        vehicles.add(new Car("Cherokee", "Jeep", 2022, "JEE999", 45000.0, Availability.FOR_SALE, 8000, UsedState.USED, 4));
        vehicles.add(new Car("Golf", "Volkswagen", 2020, "VW654", 24000.0, Availability.PROCESSING, 22000, UsedState.USED, 4));
        vehicles.add(new Car("Fiesta", "Ford", 2019, "FOR432", 18000.0, Availability.PROCESSING, 25000, UsedState.SEMIUSED, 4));
        vehicles.add(new Car("CX-5", "Mazda", 2023, "MAZ111", 35000.0, Availability.SOLD, 5000, UsedState.USED, 4));
        vehicles.add(new Car("RAV4", "Toyota", 2021, "TOY321", 33000.0, Availability.PROCESSING, 14000, UsedState.USED, 4));
        vehicles.add(new Car("CR-V", "Honda", 2022, "HON876", 34000.0, Availability.PROCESSING, 10000, UsedState.SEMIUSED, 4));
        vehicles.add(new Car("X5", "BMW", 2023, "BMW999", 70000.0, Availability.PROCESSING, 12000, UsedState.USED, 4));
        vehicles.add(new Car("E-Class", "Mercedes-Benz", 2021, "MBZ555", 65000.0, Availability.PROCESSING, 16000, UsedState.USED, 4));

    }

    public List<Car> searchCars(String brand, String name, Integer year,
                                Double price, String availability, Integer milage,
                                String usedState, Integer numDoors) {
/**
 * ARREGLAR
 */

        return super.searchVehicles(brand, name, year, price, availability, milage, usedState)
                .stream()
                .filter(car -> numDoors == null || car.getNumDoors() == numDoors)
                .collect(Collectors.toList());
    }

}
