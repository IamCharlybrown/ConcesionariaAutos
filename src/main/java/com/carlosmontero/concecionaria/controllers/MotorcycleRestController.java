package com.carlosmontero.concecionaria.controllers;


import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Motorcycle;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Motorcycles")
public class MotorcycleRestController {

    @Autowired
    MotorcycleService motorcycleService;

    @GetMapping
    public List<Motorcycle> motorcycleList(){
        return motorcycleService.findAll();
    }

    @GetMapping ("/{type}")
    public List<Motorcycle> getMotorcyclesByType(@PathVariable String type){
        return  motorcycleService.getMotorcycleByType(type);
    }
//
//    @GetMapping("/search")
//    public List<Motorcycle> searchMotorcycles(
//
//            @RequestParam(required = false) String brand,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) Integer year,
//            @RequestParam(required = false) Double price,
//            @RequestParam(required = false) String availability,
//            @RequestParam(required = false) Integer milage,
//            @RequestParam(required = false) String usedState,
//            @RequestParam(required = false) String type
//    ) {
//        return motorcycleService.searchMotorcycles
//                (brand, name, year, price, availability, milage, usedState, type);
//    }


}
