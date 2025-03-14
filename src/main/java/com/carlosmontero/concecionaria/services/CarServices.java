package com.carlosmontero.concecionaria.services;

import com.carlosmontero.concecionaria.models.Vehicles.Car;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServices extends VehicleService<Car> {

    private final List<Car> cars;

    public CarServices() {
        cars = new ArrayList<>();
        cars.add(new Car("Civic", "Honda", 2021, "CAML123", 20000.0, Availability.FOR_SALE, 1000, UsedState.NEW, 4));
        cars.add(new Car("Corolla", "Toyota", 2020, "ABC123", 25000.0, Availability.SOLD, 5000, UsedState.USED, 4));
        cars.add(new Car("Model 3", "Tesla", 2023, "TESL123", 45000.0, Availability.FOR_SALE, 12000, UsedState.USED, 4));
        cars.add(new Car("Mustang", "Ford", 2022, "FOR123", 60000.0, Availability.FOR_SALE, 3000, UsedState.NEW, 2));
        cars.add(new Car("Accord", "Honda", 2019, "HON456", 22000.0, Availability.SOLD, 20000, UsedState.SEMIUSED, 4));
        cars.add(new Car("Camry", "Toyota", 2021, "TOY789", 28000.0, Availability.FOR_SALE, 10000, UsedState.USED, 4));
        cars.add(new Car("Challenger", "Dodge", 2022, "DOD123", 55000.0, Availability.SOLD, 1500, UsedState.NEW, 2));
        cars.add(new Car("Elantra", "Hyundai", 2020, "HYU321", 20000.0, Availability.PROCESSING, 18000, UsedState.USED, 4));
        cars.add(new Car("A4", "Audi", 2021, "AUD987", 38000.0, Availability.PROCESSING, 15000, UsedState.USED, 4));
        cars.add(new Car("Series 3", "BMW", 2022, "BMW567", 42000.0, Availability.PROCESSING, 12000, UsedState.SEMIUSED, 4));
        cars.add(new Car("Model X", "Tesla", 2023, "TESL789", 90000.0, Availability.SOLD, 6000, UsedState.USED, 4));
        cars.add(new Car("Outback", "Subaru", 2021, "SUB888", 31000.0, Availability.PROCESSING, 17000, UsedState.USED, 4));
        cars.add(new Car("Cherokee", "Jeep", 2022, "JEE999", 45000.0, Availability.FOR_SALE, 8000, UsedState.USED, 4));
        cars.add(new Car("Golf", "Volkswagen", 2020, "VW654", 24000.0, Availability.PROCESSING, 22000, UsedState.USED, 4));
        cars.add(new Car("Fiesta", "Ford", 2019, "FOR432", 18000.0, Availability.PROCESSING, 25000, UsedState.SEMIUSED, 4));
        cars.add(new Car("CX-5", "Mazda", 2023, "MAZ111", 35000.0, Availability.SOLD, 5000, UsedState.USED, 4));
        cars.add(new Car("RAV4", "Toyota", 2021, "TOY321", 33000.0, Availability.PROCESSING, 14000, UsedState.USED, 4));
        cars.add(new Car("CR-V", "Honda", 2022, "HON876", 34000.0, Availability.PROCESSING, 10000, UsedState.SEMIUSED, 4));
        cars.add(new Car("X5", "BMW", 2023, "BMW999", 70000.0, Availability.PROCESSING, 12000, UsedState.USED, 4));
        cars.add(new Car("E-Class", "Mercedes-Benz", 2021, "MBZ555", 65000.0, Availability.PROCESSING, 16000, UsedState.USED, 4));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(int id) {
        for (Car c : cars) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Car getCarByPlate(String plate) {
        for (Car c : cars) {
            if (c.getPlate().equals(plate)) {
                return c;
            }
        }
        return null;
    }


    /**
     * Método para buscar carros por los siguientes parámetros;
     *
     * @param brand
     * @param name
     * @param year
     * @param price
     * @param availability
     * @param milage
     * @param usedState
     * @param numDoors
     * @return
     */


    public List<Car> searchCars(String brand, String name, Integer year, Double price,
                                String availability, Integer milage, String usedState, Integer numDoors) {
        return cars.stream().filter(car -> {
            boolean matches = true;

            // Filtrado por marca
            if (brand != null && !car.getVehicleBrand().equalsIgnoreCase(brand)) {
                matches = false;
            }

            // Filtrado por nombre
            if (name != null && !car.getVehicleName().equalsIgnoreCase(name)) {
                matches = false;
            }

            // Filtrado por año
            if (year != null && car.getVehicleYear() != year) {
                matches = false;
            }

            // Filtrado por precio
            if (price != null && car.getPrice() != price) {
                matches = false;
            }

            // Filtrado por disponibilidad (llamando a isValidAvailability)
            if (!isValidAvailability(availability, car)) {
                matches = false;
            }

            // Filtrado por kilometraje
            if (milage != null && car.getMilage() != milage) {
                matches = false;
            }

            // Filtrado por estado de uso (convertido a enum)
            if (!isValidUsedState(usedState, car)) {
                matches = false;
            }

            // Filtrado por número de puertas
            if (numDoors != null && car.getNumDoors() != (numDoors)) {
                matches = false;
            }

            return matches;
        }).collect(Collectors.toList());
    }


    /**
     * Metodos para validar los enums Availability y UsedState
     *
     * @param availability
     * @param car
     * @return
     */

    private boolean isValidAvailability(String availability, Car car) {
        if (availability == null) {
            return true; // If availability is null, don't filter by it
        }

        // Normalize the input: remove spaces, convert to uppercase
        String normalizedAvailability = availability.toUpperCase().replace(" ", "_");

        try {
            Availability availEnum = Availability.valueOf(normalizedAvailability);
            return car.getAvailability() == availEnum;
        } catch (IllegalArgumentException e) {
            // Maybe try alternative formats
            // For example, if sending "forsale" instead of "FOR_SALE"
            if (normalizedAvailability.equals("FORSALE")) {
                return car.getAvailability() == Availability.FOR_SALE;
            }
            // Add more cases as needed
            return false;
        }
    }

    private boolean isValidUsedState(String usedState, Car car) {
        if (usedState == null) {
            return true;
        }

        String normalizedUsedState = usedState.toUpperCase();

        try {
            UsedState usedStateEnum = UsedState.valueOf(normalizedUsedState);
            return car.getUsedState() == usedStateEnum;
        } catch (IllegalArgumentException e) {

            return false;
        }

    }
}
