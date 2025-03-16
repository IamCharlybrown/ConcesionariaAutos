package com.carlosmontero.concecionaria.models.Vehicles.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.Vehicles.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;

public class Car extends Vehicle {

    private int numDoors;

    public Car(int numDoors) {
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
