package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.LightTruck;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.LightTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LightTruck")
public class LightTruckRestController {

    @Autowired
    LightTruckService lightTruckService;

    @GetMapping
    public List<LightTruck> getLightTrucks(){
        return lightTruckService.findAll();
    }

    @GetMapping("/{numPassengers}")
    public List<LightTruck> getLightTrucksByNumPassengers(@PathVariable int numPassengers){
        return lightTruckService.getLightTruckByNumPassengers(numPassengers);
    }

    @PostMapping
    public ResponseEntity<LightTruck> createLightTruck(@RequestBody LightTruck lightTruck){
        return ResponseEntity.ok(lightTruckService.createLightTruck(lightTruck));
    }

}
