package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.LightTruck;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.LightTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PatchMapping("/{id}")
    public ResponseEntity<LightTruck> updateLightTruck(@PathVariable Long id,@RequestBody LightTruck lightTruck){
       Optional<LightTruck> modifiedLightTruck = lightTruckService.updateTruck(id,lightTruck);
       return ResponseEntity.of(modifiedLightTruck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LightTruck> deleteLightTruck(@PathVariable Long id){
        Optional<LightTruck> deletedLightTruck = lightTruckService.deleteTruck(id);
        return ResponseEntity.of(deletedLightTruck);
    }
}
