package com.carlosmontero.concecionaria.repository;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.enums.Availability;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.util.List;


@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, Long> {


    T findByPlateIgnoreCase(String plate);

    List<T> findByVehicleBrandIgnoreCase(String brand);
    List<T> findByVehicleNameIgnoreCase(String name);
    List<T> findByAvailability(Availability availability);
    List<T> findByUsedState(UsedState usedState);

    // También soporta combinaciones
    List<T> findByVehicleBrandAndVehicleYear(String brand, int year);
}
