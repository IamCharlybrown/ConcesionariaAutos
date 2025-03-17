package com.carlosmontero.concecionaria.models.MasterVehicleModel;

import java.util.List;

/**
 * Interfáz que sirve como base para cualquier servicio que quiera implementar la clase Vehicle con sus métodos por defecto
 * El parámetro T hace referencia al tipo de véhiculo que se quiera trabajar (caso hipotético: Car, Motorcycle, Truck, etc.)
 * @param <T>
 */
public interface VehicleService<T extends Vehicle>{
    List<T> getAllVehicles();
    T getVehicleById();
    T getVehicleByPlate();
    List<T> searchVehicles(String brand, String name, Integer year, Double price,String availability, Integer milage,String usedState);
}
