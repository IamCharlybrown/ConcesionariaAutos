package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.LightTruck;
import com.carlosmontero.concecionaria.repository.LightTruckRepository;
import com.carlosmontero.concecionaria.services.AbstractVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LightTruckService extends VehicleServiceImpl<LightTruck, LightTruckRepository> {

    private final LightTruckRepository lightTruckRepository;


    public LightTruckService(LightTruckRepository lightTruckRepository) {
        super(lightTruckRepository);
        this.lightTruckRepository= lightTruckRepository;
    }


    public List<LightTruck> getLightTruckByNumPassengers(int numPassengers){
        List<LightTruck> allLightTrucks = lightTruckRepository.findAll();

        return allLightTrucks.stream()
                .filter(lightTruck -> lightTruck.getNumPassengers() == numPassengers)
                .collect(Collectors.toList());
    }


    public LightTruck createLightTruck(LightTruck lightTruck){
        return lightTruckRepository.save(lightTruck);
    }

}
