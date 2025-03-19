package com.carlosmontero.concecionaria.services.MasterVehicleServices;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.VehicleInterface;
import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.repository.VehicleRepository;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Clase base para métodos comunes entre todos los tipos de vehículos
 * donde T es Type o "tipo" de vehículo
 *
 * @param <T>
 */

@Service
public abstract class VehicleServiceImpl<T extends Vehicle, R extends VehicleRepository> implements VehicleInterface {


    protected R repository;

    public VehicleServiceImpl(R repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void saveVehicle(T vehicle) {
        repository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }

    public Optional<T> findVehicleById(Long id) {
        return repository.findById(id);
    }

    public T getVehicleByPlate(String plate) {
        return (T) repository.findByPlateIgnoreCase(plate);
    }

    public List<T> searchVehicles(String brand, String name, Integer year, Double price,
                                        String availability, Integer milage, String usedState) {
        List<Vehicle> vehicles = repository.findAll();

        // Aplicas los filtros (lógica personalizada)
        return vehicles.stream()
                .filter(t -> brand == null || t.getVehicleBrand().equalsIgnoreCase(brand))
                .filter(t -> name == null || t.getVehicleName().equalsIgnoreCase(name))
                .filter(t -> year == null || t.getVehicleYear() == year)
                .filter(t -> price == null || Double.compare(t.getPrice(), price) == 0)
                .filter(t -> milage == null || t.getMilage() == milage)
                .map(vehicle -> (T) vehicle)
                .collect(Collectors.toList());
    }
}

