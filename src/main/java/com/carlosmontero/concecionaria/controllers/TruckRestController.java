package com.carlosmontero.concecionaria.controllers;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Truck;
import com.carlosmontero.concecionaria.services.OtherVehicleServices.TruckServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/Truck")
public class TruckRestController {

    @Autowired
    private TruckServices truckServices;

    @GetMapping
    public List<Truck> truckList() {
        return truckServices.getAllVehicles();
    }

    @GetMapping("/LoadCapacity/{Capacity}")
    public List<Truck> TrucksByCapacity(@PathVariable int Capacity) {
        return truckServices.getTrucksByCapacity(Capacity);
    }

    @GetMapping("/Axis/{numAxis}")
    public List<Truck> TrucksByAxis(@PathVariable int numAxis){
        return truckServices.getTrucksByAxis(numAxis);
    }

    @GetMapping("/Permit/{needPermit}")
    public List<Truck> TrucksByPermit(@PathVariable String needPermit){
        return truckServices.getTrucksByPermit(needPermit);

    }

    @GetMapping("/TowingSystem/{hasTowingSystem}")
    public List<Truck> TrucksByTowingSystem(@PathVariable String hasTowingSystem){
        return truckServices.getTrucksByTowingSystem(hasTowingSystem);

    }
}
