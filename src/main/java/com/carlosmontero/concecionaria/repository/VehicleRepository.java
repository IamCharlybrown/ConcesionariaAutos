package com.carlosmontero.concecionaria.repository;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {


    // Spring Data automáticamente implementa métodos como:
    // findAll(), findById(), save(), deleteById(), etc.

    // Puedes agregar métodos personalizados:
    List<Vehicle> findByPlateIgnoreCase(String plate);
    List<Vehicle> findByVehicleBrandIgnoreCase(String brand);
    List<Vehicle> findByVehicleNameIgnoreCase(String name);

    // También soporta combinaciones
    List<Vehicle> findByVehicleBrandAndVehicleYear(String brand, int year);
}
