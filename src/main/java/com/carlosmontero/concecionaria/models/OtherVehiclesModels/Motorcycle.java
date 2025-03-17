package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.MotorcycleType;
import com.carlosmontero.concecionaria.utils.UsedState;

public class Motorcycle extends Vehicle {

    MotorcycleType MotorcycleType;

    public Motorcycle(MotorcycleType MotorcycleType) {
        this.MotorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear, String plate, double price, Availability availability, int milage, UsedState usedState,  MotorcycleType MotorcycleType) {
        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        this.MotorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear, MotorcycleType MotorcycleType) {
        super(vehicleName, vehicleBrand, vehicleYear);
        this.MotorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear, int milage, UsedState usedState, MotorcycleType MotorcycleType) {
        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        this.MotorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleBrand, String vehicleName, MotorcycleType MotorcycleType) {
        super(vehicleBrand, vehicleName);
        this.MotorcycleType = MotorcycleType;
    }

    public String getMotorcycleType() {
        return MotorcycleType.toString();
    }

    public void setMotorcycleType(String MotorcycleType) {
        MotorcycleType = this.MotorcycleType.toString();
    }
}
