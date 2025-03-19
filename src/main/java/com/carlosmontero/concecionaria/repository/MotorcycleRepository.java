package com.carlosmontero.concecionaria.repository;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Motorcycle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleRepository extends VehicleRepository<Motorcycle> {
    //List<Vehicle> findByMotorcycleTypeIgnoreCase(String motorcycleType);

}
