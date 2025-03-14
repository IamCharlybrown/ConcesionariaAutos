package com.carlosmontero.concecionaria.models.Vehicles;

import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;

public class Motorcicle extends Vehicle{
    private String MotorcicleType;

    public Motorcicle(String motorcicleType) {
        MotorcicleType = motorcicleType;
    }

    public Motorcicle(String vehicleName, String vehicleBrand, int vehicleYear, String plate, double price, Availability availability, int milage, UsedState usedState, String motorcicleType) {
        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        MotorcicleType = motorcicleType;
    }

    public Motorcicle(String vehicleName, String vehicleBrand, int vehicleYear, String motorcicleType) {
        super(vehicleName, vehicleBrand, vehicleYear);
        MotorcicleType = motorcicleType;
    }

    public Motorcicle(String vehicleName, String vehicleBrand, int vehicleYear, int milage, UsedState usedState, String motorcicleType) {
        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        MotorcicleType = motorcicleType;
    }

    public Motorcicle(String vehicleBrand, String vehicleName, String motorcicleType) {
        super(vehicleBrand, vehicleName);
        MotorcicleType = motorcicleType;
    }

    public String getMotorcicleType() {
        return MotorcicleType;
    }

    public void setMotorcicleType(String motorcicleType) {
        MotorcicleType = motorcicleType;
    }
}
