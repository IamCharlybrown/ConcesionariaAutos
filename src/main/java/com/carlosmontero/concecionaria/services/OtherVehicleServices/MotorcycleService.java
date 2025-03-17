package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Motorcycle;
import com.carlosmontero.concecionaria.services.MasterVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.MotorcycleType;
import com.carlosmontero.concecionaria.utils.UsedState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MotorcycleService extends VehicleServiceImpl<Motorcycle> {

    protected List<Motorcycle> motorcycleList = new ArrayList<>();

    public MotorcycleService() {
        super();
        vehicles.add(new Motorcycle("Ninja ZX-10R", "Kawasaki", 2022, "MT01234", 18999.0, Availability.FOR_SALE, 998, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Street Glide", "Harley-Davidson", 2021, "MT02345", 21999.0, Availability.FOR_SALE, 1868, UsedState.USED, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("Africa Twin", "Honda", 2023, "MT03456", 14799.0, Availability.FOR_SALE, 1084, UsedState.NEW, MotorcycleType.TOURING));
        vehicles.add(new Motorcycle("R1250GS", "BMW", 2022, "MT04567", 19500.0, Availability.FOR_SALE, 1254, UsedState.NEW, MotorcycleType.TOURING));
        vehicles.add(new Motorcycle("Panigale V4", "Ducati", 2023, "MT05678", 23995.0, Availability.FOR_SALE, 1103, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("MT-09", "Yamaha", 2021, "MT06789", 9599.0, Availability.SOLD, 890, UsedState.USED, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Scrambler", "Ducati", 2022, "MT07890", 11995.0, Availability.FOR_SALE, 803, UsedState.NEW, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("Duke 390", "KTM", 2023, "MT08901", 5499.0, Availability.FOR_SALE, 373, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("GSX-R750", "Suzuki", 2021, "MT09012", 12499.0, Availability.FOR_SALE, 750, UsedState.USED, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Rebel 500", "Honda", 2022, "MT10123", 6299.0, Availability.FOR_SALE, 471, UsedState.NEW, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("Vespa GTS 300", "Piaggio", 2023, "MT11234", 7499.0, Availability.FOR_SALE, 278, UsedState.NEW, MotorcycleType.SCOOTER));
        vehicles.add(new Motorcycle("Road King", "Harley-Davidson", 2020, "MT12345", 19999.0, Availability.SOLD, 1746, UsedState.USED, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("CRF450R", "Honda", 2023, "MT13456", 9599.0, Availability.FOR_SALE, 449, UsedState.NEW, MotorcycleType.OFF_ROAD));
        vehicles.add(new Motorcycle("Z900", "Kawasaki", 2022, "MT14567", 8999.0, Availability.FOR_SALE, 948, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Bonneville T120", "Triumph", 2021, "MT15678", 12999.0, Availability.FOR_SALE, 1200, UsedState.USED, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("CB650R", "Honda", 2022, "MT16789", 9399.0, Availability.FOR_SALE, 649, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("XSR900", "Yamaha", 2023, "MT17890", 9999.0, Availability.FOR_SALE, 890, UsedState.NEW, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("V-Strom 650", "Suzuki", 2021, "MT18901", 8999.0, Availability.FOR_SALE, 645, UsedState.USED, MotorcycleType.TOURING));
        vehicles.add(new Motorcycle("RC 390", "KTM", 2022, "MT19012", 5699.0, Availability.SOLD, 373, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Scout", "Indian", 2023, "MT20123", 14999.0, Availability.FOR_SALE, 1133, UsedState.NEW, MotorcycleType.CRUISER));
        vehicles.add(new Motorcycle("Ninja 400", "Kawasaki", 2022, "MT21234", 5399.0, Availability.FOR_SALE, 399, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("Monster", "Ducati", 2021, "MT22345", 12195.0, Availability.FOR_SALE, 937, UsedState.USED, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("DR-Z400", "Suzuki", 2023, "MT23456", 7499.0, Availability.FOR_SALE, 398, UsedState.NEW, MotorcycleType.OFF_ROAD));
        vehicles.add(new Motorcycle("Trident 660", "Triumph", 2022, "MT24567", 8195.0, Availability.FOR_SALE, 660, UsedState.NEW, MotorcycleType.SPORT));
        vehicles.add(new Motorcycle("PCX", "Honda", 2023, "MT25678", 4099.0, Availability.FOR_SALE, 157, UsedState.NEW, MotorcycleType.SCOOTER));
    }

    /**
     * Servicio para retornar tipo de motos
     *
     * @param motorcycleType
     * @return
     */

    public List<Motorcycle> getMotorcycleByType(String motorcycleType) {

        motorcycleList.clear();

        for (Motorcycle m : vehicles) {
            if (m.getMotorcycleType().equalsIgnoreCase(motorcycleType)) {
                motorcycleList.add(m);
            }
        }
        return motorcycleList;
    }

    public List<Motorcycle> searchMotorcycles(String brand, String name, Integer year, Double price,
                                              String availability, Integer milage, String usedState, String type) {

        List<Motorcycle> filteredList = super.searchVehicles(brand, name, year, price, availability, milage, usedState);

        return filteredList.stream()
                .filter(m -> type == null || m.getMotorcycleType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
