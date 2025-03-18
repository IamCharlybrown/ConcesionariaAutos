package com.carlosmontero.concecionaria.controllers;


import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.CarServices;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.MotorcycleService;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.TruckServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Vehicles")


/*
 *
 * Clase Maestra para mostrar todos los tipos de vehículos, sin importar la clase de vehículo
 *
 */

public class MasterVehicleRestController {

    @Autowired
    private CarServices carService;

    @Autowired
    private MotorcycleService motorcycleService;

    @Autowired
    private TruckServices truckServices;


    @GetMapping
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(carService.getAllVehicles());
        allVehicles.addAll(motorcycleService.getAllVehicles());
        allVehicles.addAll(truckServices.getAllVehicles());
        return allVehicles;
    }


    @GetMapping("/{Id}")
    public Vehicle getVehicleById(@PathVariable int Id) {
        for (Vehicle v : getAllVehicles()) {
            if (v.getId() == Id) {
                return v;
            }

        }
        return null;

    }

    @GetMapping("/plate/{plate}")
    public Vehicle getVehicleByPlate(@PathVariable String plate) {
        for (Vehicle v : getAllVehicles()) {
            if (v.getPlate().equalsIgnoreCase(plate)) {
                return v;
            }

        }
        return null;
    }

    @GetMapping("/search/{availability}")
    public List<Vehicle> getVehicleByAvailability(@PathVariable String availability) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : getAllVehicles()) {
            if (v.getAvailability().toString().equalsIgnoreCase(availability)) {
                vehicles.add(v);
            }
        }
        return vehicles;

    }

    @GetMapping("/search/useState/{useState}")
    public List<Vehicle> getVehiclesByUseState(@PathVariable String useState) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : getAllVehicles()) {
            if (v.getUsedState().toString().equalsIgnoreCase(useState)) {
                vehicles.add(v);
            }
        }
        return vehicles;
    }


}
