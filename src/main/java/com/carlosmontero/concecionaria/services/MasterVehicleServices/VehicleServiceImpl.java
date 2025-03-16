package com.carlosmontero.concecionaria.services.MasterVehicleServices;

import com.carlosmontero.concecionaria.models.Vehicles.MasterVehicleModel.VehicleInterface;
import com.carlosmontero.concecionaria.models.Vehicles.MasterVehicleModel.Vehicle;
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

    public VehicleServiceImpl(){
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
     * Método para buscar Vehiculos por los siguientes parámetros;
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
        return vehicles.stream().filter(v -> {
            boolean matches = true;

            // Filtrado por marca
            if (brand != null && !v.getVehicleBrand().equalsIgnoreCase(brand)) {
                matches = false;
            }

            // Filtrado por nombre
            if (name != null && !v.getVehicleName().equalsIgnoreCase(name)) {
                matches = false;
            }

            // Filtrado por año
            if (year != null && v.getVehicleYear() != year) {
                matches = false;
            }

            // Filtrado por precio
            if (price != null && v.getPrice() != price) {
                matches = false;
            }

            // Filtrado por disponibilidad (llamando a isValidAvailability)
            if (!isValidAvailability(availability, v)) {
                matches = false;
            }

            // Filtrado por kilometraje
            if (milage != null && v.getMilage() != milage) {
                matches = false;
            }

            // Filtrado por estado de uso (convertido a enum)
            if (!isValidUsedState(usedState, v)) {
                matches = false;
            }


            return matches;
        }).collect(Collectors.toList());
    }


    /**
     * Metodos para validar los enums Availability y UsedState
     *
     * @param availability
     * @return true
     */

    protected boolean isValidAvailability(String availability, T vehicle) {
        if(availability== null){
            return false;
        }
        try {
            return vehicle.getAvailability() == Availability.valueOf(availability.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    protected boolean isValidUsedState(String usedState, T vehicle) {
        if(usedState== null){
            return false;
        }
        try {
            return vehicle.getUsedState() == UsedState.valueOf(usedState.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
