package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.repository.CarRepository;
import com.carlosmontero.concecionaria.services.MasterVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lógica para manejo de solicitudes HTTP para vehículos tipo Car.
 */
@Service
public class CarServices extends VehicleServiceImpl<Car, CarRepository> {

    private final CarRepository carRepository;

    public CarServices(CarRepository carRepository) {
        super(carRepository);
        this.carRepository = carRepository;
    }

    @Transactional
    public void addCars(){
        List<Car> vehicles = new ArrayList<>();
    }

    public List<Car> getCarsByNumDoors(int numDoors) {
        List<Car> allCars = carRepository.findAll();

        return allCars.stream()
                .filter(car -> car.getNumDoors() == numDoors)
                .collect(Collectors.toList());
    }

    public List<Car> searchCars(String brand, String name, Integer year,
                                Double price, String availability, Integer milage,
                                String usedState, Integer numDoors) {

        List<Car> filteredCars = super.searchVehicles(brand, name, year, price, availability, milage, usedState);

        return filteredCars.stream()
                .filter(car -> numDoors == null || car.getNumDoors() == numDoors)
                .collect(Collectors.toList());
    }

}
