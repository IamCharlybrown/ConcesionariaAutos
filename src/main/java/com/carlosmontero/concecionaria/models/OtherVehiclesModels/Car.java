package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.enums.Availability;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {


    @Column(name = "num_doors")

    @Positive(message = "El valor debe ser positivo")
    private int numDoors;

    /**
     * Constructores para cada tipo de uso
     */

    public Car(){
        super();
    }

    public Car(int numDoors) {
        super();
        this.numDoors= numDoors;
    }

    public Car(String vehicleName, String vehicleBrand, int vehicleYear, String plate, double price, Availability availability, int milage, UsedState usedState, int numDoors) {
        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        this.numDoors = numDoors;
    }

    public Car(String vehicleName, String vehicleBrand, int vehicleYear, int numDoors) {
        super(vehicleName, vehicleBrand, vehicleYear);
        this.numDoors = numDoors;
    }

    public Car(String vehicleName, String vehicleBrand, int vehicleYear, int milage, UsedState usedState, int numDoors) {
        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        this.numDoors = numDoors;
    }

    public Car(String vehicleBrand, String vehicleName, int numDoors) {
        super(vehicleBrand, vehicleName);
        this.numDoors = numDoors;
    }

    /**
     * Getters y Setters
     * @return
     */

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}
