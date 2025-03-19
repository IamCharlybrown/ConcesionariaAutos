package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Column(name = "num_doors")
    private int numDoors;

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

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}
