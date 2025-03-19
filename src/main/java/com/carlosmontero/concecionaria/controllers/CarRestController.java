package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarServices carService;

    @GetMapping
    public List<Car> getCars() {
        return carService.findAll();
    }

    @PostMapping("/add")
    public List<Car> addCars() {
        carService.addCars();
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
}