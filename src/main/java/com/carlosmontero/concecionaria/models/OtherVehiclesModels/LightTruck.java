package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.enums.Availability;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "light_trucks")
public class LightTruck extends Vehicle {

    @Column(name = "numPassengers")
    private int numPassengers;

    /**
     * Constructores
     */

    public LightTruck() {
        super();
    }

    public LightTruck(String vehicleName, String vehicleBrand, int vehicleYear,
                      String plate, double price, Availability availability,
                      int milage, UsedState usedState, int numPassengers) {
        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        this.numPassengers=numPassengers;
    }

    public LightTruck(String vehicleName, String vehicleBrand, int vehicleYear) {
        super(vehicleName, vehicleBrand, vehicleYear);
    }

    public LightTruck(String vehicleName, String vehicleBrand, int vehicleYear,
                      int milage, UsedState usedState,int numPassengers) {
        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        this.numPassengers=numPassengers;
    }

    public LightTruck(String vehicleBrand, String vehicleName) {
        super(vehicleBrand, vehicleName);
    }

    /**
     * Getters y setters
     */

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }
}
