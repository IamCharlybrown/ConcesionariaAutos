package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Truck;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Controlador API Trucks
 */

@RestController
@RequestMapping("/Truck")
public class TruckRestController {

    @Autowired
    private TruckService truckServices;

    @GetMapping
    public List<Truck> truckList() {
        return truckServices.findAll();
    }


    @GetMapping("/LoadCapacity/{Capacity}")
    public List<Truck> TrucksByCapacity(@PathVariable int Capacity) {
        return truckServices.getTrucksByCapacity(Capacity);
    }

    @GetMapping("/Axles/{numberOfAxles}")
    public List<Truck> TrucksByAxis(@PathVariable int numberOfAxles) {
        return truckServices.getTrucksByAxles(numberOfAxles);
    }

    @GetMapping("/Permit/{needPermit}")
    public List<Truck> TrucksByPermit(@PathVariable String needPermit) {
        return truckServices.getTrucksBySpecialPermitRequired(needPermit);

    }

    @GetMapping("/TowingSystem/{hasTowingSystem}")
    public List<Truck> TrucksByTowingSystem(@PathVariable String hasTowingSystem) {
        return truckServices.getTrucksByHasTowingSystem(hasTowingSystem);

    }

    @PostMapping
    public ResponseEntity<Truck> createTruck(@RequestBody Truck truck) {

        truckServices.createTruck(truck);
        return ResponseEntity.ok(truck);
    }
}
