package com.carlosmontero.concecionaria.controllers;


import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.MasterVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    MasterVehicleService masterVehicleService;

    @GetMapping
    public List<Vehicle> AllVehicles() {
        return masterVehicleService.getAllVehicles();
    }

    /**
     * BUSCAR VEHÍCULO POR ID
     *
     * @param Id
     * @return
     */

    @GetMapping("/{Id}")
    public Vehicle getVehicleById(@PathVariable int Id) {
        return masterVehicleService.getVehicleById(Id);

    }

    /**
     * BUSCAR VEHÍCULO POR PLACA
     *
     * @param plate
     * @return
     */

    @GetMapping("/plate/{plate}")
    public Vehicle getVehicleByPlate(@PathVariable String plate) {
        return masterVehicleService.getVehicleByPlate(plate);
    }

    /**
     * BUSCAR VEHÍCULO POR DISPONIBILIDAD
     *
     * @param availability
     * @return
     */

    @GetMapping("/search/{availability}")
    public List<Vehicle> getVehicleByAvailability(@PathVariable String availability) {
        return masterVehicleService.getVehicleByAvailability(availability);
    }

    /**
     * BUSCAR VEHÍCULOS POR USO
     *
     * @param useState
     * @return
     */

    @GetMapping("/search/useState/{useState}")
    public List<Vehicle> getVehiclesByUseState(@PathVariable String useState) {
        return masterVehicleService.getVehiclesByUseState(useState);
    }

    /**
     * prueba para agregar listas de vehículos
     *
     * @return
     */

    @PostMapping("/add")
    public ResponseEntity<String> addVehicles() {
        return ResponseEntity.ok("Vehicles added successfully");
    }


}
