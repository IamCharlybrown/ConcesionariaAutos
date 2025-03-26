package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.enums.Availability;
import com.carlosmontero.concecionaria.utils.enums.MotorcycleType;
import com.carlosmontero.concecionaria.utils.enums.UsedState;
import jakarta.persistence.*;


@Entity
@Table(name = "motorcycles")
public class Motorcycle extends Vehicle {


    @Column(name = "motorcyle_type")
    private MotorcycleType motorcycleType;

    public Motorcycle() {
        super();
    }

    public Motorcycle(MotorcycleType motorcycleType) {
        super();
        this.motorcycleType = motorcycleType;
    }


    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear, String plate,
                      double price, Availability availability, int milage, UsedState usedState,
                      MotorcycleType MotorcycleType) {

        super(vehicleName, vehicleBrand, vehicleYear, plate, price, availability, milage, usedState);
        this.motorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear,
                      MotorcycleType MotorcycleType) {

        super(vehicleName, vehicleBrand, vehicleYear);
        this.motorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleName, String vehicleBrand, int vehicleYear,
                      int milage, UsedState usedState, MotorcycleType MotorcycleType) {

        super(vehicleName, vehicleBrand, vehicleYear, milage, usedState);
        this.motorcycleType = MotorcycleType;
    }

    public Motorcycle(String vehicleBrand, String vehicleName, MotorcycleType MotorcycleType) {
        super(vehicleBrand, vehicleName);
        this.motorcycleType = MotorcycleType;
    }

    public String getMotorcycleType() {
        if (this.motorcycleType != null) {

            return motorcycleType.toString();
        }
        return null;
    }

    public void setMotorcycleType(String motorcycleType) {

        if (motorcycleType != null && !motorcycleType.isEmpty()) {
            this.motorcycleType = MotorcycleType.valueOf(motorcycleType.toUpperCase());
        }
    }
}
