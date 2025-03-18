package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;

public class Truck extends Vehicle {

    private int loadCapacity;
    private int numberOfAxles;
    private boolean specialPermitRequired;
    private boolean hasTowingSystem;


    public Truck() {
        super();
    }

    public Truck(int loadCapacity, int numberOfAxles, boolean specialPermitRequired,
                 boolean hasTowingSystem) {

        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.specialPermitRequired = specialPermitRequired;
        this.hasTowingSystem = hasTowingSystem;

    }

    public Truck(String vehicleName, String vehicleBrand, int vehicleYear, String plate,
                 double price, Availability availability, int milage, UsedState usedState,
                 int loadCapacity, int numberOfAxles, boolean specialPermitRequired,
                 boolean hasTowingSystem) {

        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.specialPermitRequired = specialPermitRequired;
        this.hasTowingSystem = hasTowingSystem;

    }

    public Truck(String vehicleName, String vehicleBrand, int vehicleYear,
                 int loadCapacity, int numberOfAxles, boolean specialPermitRequired,
                 boolean hasTowingSystem) {

        super(vehicleName, vehicleBrand, vehicleYear);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.specialPermitRequired = specialPermitRequired;
        this.hasTowingSystem = hasTowingSystem;
    }

    public Truck(String vehicleName, String vehicleBrand, int vehicleYear,
                 int milage, UsedState usedState, int loadCapacity, int numberOfAxles,
                 boolean specialPermitRequired, boolean hasTowingSystem) {

        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.specialPermitRequired = specialPermitRequired;
        this.hasTowingSystem = hasTowingSystem;

    }

    public Truck(String vehicleBrand, String vehicleName, int loadCapacity,
                 int numberOfAxles, boolean specialPermitRequired,
                 boolean hasTowingSystem) {

        super(vehicleBrand, vehicleName);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.specialPermitRequired = specialPermitRequired;
        this.hasTowingSystem = hasTowingSystem;

    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public boolean isSpecialPermitRequired() {
        return specialPermitRequired;
    }

    public void setSpecialPermitRequired(boolean specialPermitRequired) {
        this.specialPermitRequired = specialPermitRequired;
    }


    public boolean isHasTowingSystem() {
        return hasTowingSystem;
    }

    public void setHasTowingSystem(boolean hasTowingSystem) {
        this.hasTowingSystem = hasTowingSystem;
    }
}
