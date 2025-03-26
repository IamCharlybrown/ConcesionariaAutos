package com.carlosmontero.concecionaria.repository;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends VehicleRepository<Car> {

    public List<Vehicle> findByNumDoors(int numDoors);
}
