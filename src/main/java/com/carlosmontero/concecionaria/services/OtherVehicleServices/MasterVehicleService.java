package com.carlosmontero.concecionaria.services.OtherVehicleServices;


import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterVehicleService {

    @Autowired
    private CarServices carService;

    @Autowired
    private MotorcycleService motorcycleService;

    @Autowired
    private TruckService truckServices;

    @Autowired
    private LightTruckService lightTruckService;

    @Cacheable("vehicles")
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(carService.findAll());
        allVehicles.addAll(motorcycleService.findAll());
        allVehicles.addAll(truckServices.findAll());
        allVehicles.addAll(lightTruckService.findAll());
        return allVehicles;
    }

    public Vehicle getVehicleById(int id) {
        return getAllVehicles().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Vehicle getVehicleByPlate(String plate) {
        return getAllVehicles().stream()
                .filter(v -> v.getPlate().equalsIgnoreCase(plate))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> getVehicleByAvailability(String availability) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : getAllVehicles()) {
            if (v.getAvailability().toString().equalsIgnoreCase(availability)) {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByUseState(String useState) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : getAllVehicles()) {
            if (v.getUsedState().toString().equalsIgnoreCase(useState)) {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    @CacheEvict(value = "vehicles", allEntries = true)
    public void clearCache() {
        System.out.println("Cache cleared!");
    }
}

