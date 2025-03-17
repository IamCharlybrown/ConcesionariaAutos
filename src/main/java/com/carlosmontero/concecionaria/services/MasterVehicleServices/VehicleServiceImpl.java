package com.carlosmontero.concecionaria.services.MasterVehicleServices;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.VehicleInterface;
import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Clase base para métodos comunes entre todos los tipos de vehículos
 * donde T es Type o "tipo" de vehículo
 * @param <T>
 */

@Service
public abstract class VehicleServiceImpl<T extends Vehicle> implements VehicleInterface {


    protected List<T> vehicles;

    public VehicleServiceImpl() {
        vehicles = new ArrayList<>();
    }

    public VehicleServiceImpl(List<T> vehicles) {
        this.vehicles = vehicles;
    }


    public List<T> getAllVehicles() {
        return vehicles;
    }


    public T getVehicleById(int id) {
        return vehicles.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public T getVehicleByPlate(String plate) {
        return vehicles.stream()
                .filter(v -> v.getPlate().equalsIgnoreCase(plate))
                .findFirst()
                .orElse(null);
    }


    /**
     * Buscar Vehículos por los siguientes parámetros;
     *
     * @param brand
     * @param name
     * @param year
     * @param price
     * @param availability
     * @param milage
     * @param usedState
     * @return
     */


    public List<T> searchVehicles(String brand, String name, Integer year, Double price,
                                  String availability, Integer milage, String usedState) {
        return vehicles.stream()
                .filter(v -> brand == null || v.getVehicleBrand().equalsIgnoreCase(brand))
                .filter(v -> name == null || v.getVehicleName().equalsIgnoreCase(name))
                .filter(v -> year == null || v.getVehicleYear() == year)
                .filter(v -> price == null || Double.compare(v.getPrice(), price) == 0)
                .filter(v -> milage == null || v.getMilage() == milage)
                .filter(v -> isValidAvailability(availability, v))
                .filter(v -> isValidUsedState(usedState, v))
                .collect(Collectors.toList());

    }

    /**
     * Metodos para validar los enums Availability y UsedState
     *
     * @param availability
     * @return true
     */
    protected boolean isValidAvailability(String availability, T vehicle) {
        if (availability == null) {
            return true; // No filtrar si no se envió
        }
        try {
            Availability desired = Availability.valueOf(availability.toUpperCase().replace(" ", "_"));
            return vehicle.getAvailability() == desired;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    protected boolean isValidUsedState(String usedState, T vehicle) {
        if (usedState == null) {
            return true;
        }
        try {
            UsedState desired = UsedState.valueOf(usedState.toUpperCase());
            return vehicle.getUsedState() == desired;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
