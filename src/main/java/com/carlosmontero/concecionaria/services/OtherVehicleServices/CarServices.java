package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.repository.CarRepository;
import com.carlosmontero.concecionaria.services.AbstractVehicleServices.VehicleServiceImpl;
import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    /**
     * Metodo para crear un nuevo carro
     * @param car carro a crear
     * @return car
     */
    public Car createCar(Car car){
        return carRepository.save(car);
    }

    /**
     * Metodo para modificar un carro
     * @param id carro a modificar
     * @param updatedData objeto de carro modificado
     * @return carro módificado
     */

    public Optional<Car> updateCar(Long id, Car updatedData) {
        return carRepository.findById(id).map(car -> {
            BeanUtils.copyProperties(updatedData, car, "id");
            return carRepository.save(car);
        });
    }

    public Optional<Car> deleteCar(Long id){
        Optional<Car> car = carRepository.findById(id);
        car.ifPresent(carRepository::delete);
        return car;
    }

}
