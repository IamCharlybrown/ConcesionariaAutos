package com.carlosmontero.concecionaria.controllers;


import com.carlosmontero.concecionaria.models.Vehicles.Vehicle;
import com.carlosmontero.concecionaria.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Vehicles")

public class VehicleRestControler {
    @Autowired
    private VehicleService<Vehicle> vehicle;


    @GetMapping
    public List<Vehicle> getALLVehicles(){
        return vehicle.getAllVehicles();
    }

    @GetMapping("/{Id}")
    public Vehicle getVehicleByID(int Id){
        return vehicle.getVehicleById(Id);
    }

    @GetMapping("/plate/{plate}")
    public Vehicle getVehicleByPlate(String plate){
        return vehicle.getVehicleByPlate(plate);
    }

    @GetMapping("/search")
    public List<Vehicle> searchVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String availability,
            @RequestParam(required = false) Integer milage,
            @RequestParam(required = false) String usedState
    ){
        return searchVehicles(brand,name,year,price,availability,milage,usedState);
    }


}
