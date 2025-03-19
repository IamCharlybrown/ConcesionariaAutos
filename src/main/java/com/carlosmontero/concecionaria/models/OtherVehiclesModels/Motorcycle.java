package com.carlosmontero.concecionaria.models.OtherVehiclesModels;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.MotorcycleType;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motorcycles")
public class Motorcycle extends Vehicle {

    @Column(name = "motorcyle_type")
    private MotorcycleType motorcycleType;

    public Motorcycle(){
        super();
    }

    public Motorcycle(MotorcycleType MotorcycleType) {
        super();
        this.motorcycleType = MotorcycleType;
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
        return motorcycleType.toString();
    }

    public void setMotorcycleType(String MotorcycleType) {
        MotorcycleType = this.motorcycleType.toString();
    }
}
