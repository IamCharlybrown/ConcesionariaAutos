package com.carlosmontero.concecionaria.models.MasterVehicleModel;

import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.IdGenerator;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicles")
public class Vehicle implements VehicleInterface {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String vehicleName;
    private String vehicleBrand;
    private int vehicleYear;
    private String plate;
    private double price;
    private Availability availability;
    private int milage;
    private UsedState usedState;

    /**
     * Constructor requerido por JPA
     */
    public Vehicle() {
    }

    /**
     * Constructor que recibe todos los párametros dentro de la clase
     *
     * @param vehicleName
     * @param vehicleBrand
     * @param vehicleYear
     * @param plate
     * @param price
     * @param availability
     */

    public Vehicle(String vehicleName, String vehicleBrand, int vehicleYear, String plate, double price, Availability availability, int milage, UsedState usedState) {
        this();
        this.vehicleName = vehicleName;
        this.vehicleBrand = vehicleBrand;
        this.vehicleYear = vehicleYear;
        this.plate = plate;
        this.price = price;
        this.availability = availability;
        this.milage = milage;
        this.usedState = usedState;
    }

    /**
     * Constructor para registro simple de un Vehículo nuevo
     *
     * @param vehicleName
     * @param vehicleBrand
     * @param vehicleYear
     */

    public Vehicle(String vehicleName, String vehicleBrand, int vehicleYear) {
        this();
        this.vehicleName = vehicleName;
        this.vehicleBrand = vehicleBrand;
        this.vehicleYear = vehicleYear;
        this.milage = 1000;
        this.usedState = UsedState.NEW;
    }

    /**
     * Constructor para coche usado / semiusado
     *
     * @param vehicleName
     * @param vehicleBrand
     * @param vehicleYear
     * @param milage
     * @param usedState
     */

    public Vehicle(String vehicleName, String vehicleBrand, int vehicleYear, int milage, UsedState usedState) {
        this();
        this.vehicleName = vehicleName;
        this.vehicleBrand = vehicleBrand;
        this.vehicleYear = vehicleYear;
        this.milage = milage;
        this.usedState = usedState;
    }

    /**
     * Constructor para búsqueda por marca y nombre
     *
     * @param vehicleBrand
     * @param vehicleName
     */
    public Vehicle(String vehicleBrand, String vehicleName) {
        this.vehicleBrand = vehicleBrand;
        this.vehicleName = vehicleName;
    }


    /**
     * Getters y setters
     *
     * @return
     */

    public int getId() {
        return Id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public UsedState getUsedState() {
        return usedState;
    }

    public void setUsedState(UsedState usedState) {
        this.usedState = usedState;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id=" + Id +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", plate='" + plate + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", milage=" + milage +
                ", usedState=" + usedState +
                '}';
    }
}
