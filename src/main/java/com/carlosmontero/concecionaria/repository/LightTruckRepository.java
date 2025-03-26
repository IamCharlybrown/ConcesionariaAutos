package com.carlosmontero.concecionaria.repository;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.LightTruck;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightTruckRepository extends VehicleRepository<LightTruck>{

    public List<LightTruck> getLightTruckByNumPassengers(int numPassengers);

}
