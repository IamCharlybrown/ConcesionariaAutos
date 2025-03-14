package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.Vehicles.Car;
import com.carlosmontero.concecionaria.services.CarServices;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    /**
     * Instanciamos
     */
    @Autowired
    private CarServices carServices;


    @GetMapping
    public List<Car> getCars() {
        return carServices.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carServices.getCarById(id);

    }
    @GetMapping("/plate/{plate}")
    public Car getCaByPlate(@PathVariable String plate){
        return carServices.getCarByPlate(plate);
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
        return carServices.searchCars(brand, name, year, price, availability, milage, usedState, numDoors);
    }


}
