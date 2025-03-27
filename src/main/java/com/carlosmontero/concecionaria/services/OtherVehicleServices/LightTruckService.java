package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.LightTruck;
import com.carlosmontero.concecionaria.repository.LightTruckRepository;
import com.carlosmontero.concecionaria.services.AbstractVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.beans.BeanProperty;
import java.util.List;
import java.util.Optional;
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

    public Optional<LightTruck> updateTruck(Long id, LightTruck updatedData){
       return lightTruckRepository.findById(id).map(lightTruck -> {
            BeanUtils.copyProperties(updatedData,lightTruck,"id");
            return lightTruckRepository.save(lightTruck);
        });
    }

    public Optional<LightTruck> deleteTruck(Long id){
       Optional<LightTruck> lightTruck = lightTruckRepository.findById(id);
       lightTruck.ifPresent(lightTruckRepository::delete);
       return lightTruck;
    }
}
