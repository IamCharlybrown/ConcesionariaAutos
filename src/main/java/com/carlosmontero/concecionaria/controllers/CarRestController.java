package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.CarServices;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarServices carService;

    @GetMapping
    public List<Car> getCars() {
        return carService.findAll();
    }


    @GetMapping("numDoors/{numDoors}")
    public List<Car> getCarByNumDoors(@PathVariable int numDoors){
        return carService.getCarsByNumDoors(numDoors);
    }

    @GetMapping("/search")
    public List<Car> searchCars(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String availability,
            @RequestParam(required = false) Integer milage,
            @RequestParam(required = false) String usedState,
            @RequestParam(required = false) Integer numDoors
    ) {
        return carService.searchCars
                (brand, name, year, price, availability, milage, usedState, numDoors);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return ResponseEntity.ok(newCar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> modifyCar(@PathVariable Long id, @RequestBody Car car){
        Optional<Car> modifiedCar = carService.updateCar(id,car);
        return ResponseEntity.of(modifiedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
       Optional<Car> deletedCar = carService.deleteCar(id);
       return ResponseEntity.of(deletedCar);
    }

}