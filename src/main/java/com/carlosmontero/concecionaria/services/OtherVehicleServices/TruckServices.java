package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Truck;
import com.carlosmontero.concecionaria.repository.TruckRepository;
import com.carlosmontero.concecionaria.services.MasterVehicleServices.VehicleServiceImpl;

import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckServices extends VehicleServiceImpl<Truck, TruckRepository> {

    private TruckRepository truckRepository;

    public TruckServices(TruckRepository truckRepository) {
        super(truckRepository);
        this.truckRepository = truckRepository;
//        vehicles.add(new Truck("F-150", "Ford", 2022, "ABC-123", 45000, Availability.FOR_SALE, 5000, UsedState.NEW, 1500, 2, false, false));
//        vehicles.add(new Truck("Silverado 2500HD", "Chevrolet", 2021, "DEF-456", 47000, Availability.FOR_SALE, 12000, UsedState.USED, 2000, 2, false, true));
//        vehicles.add(new Truck("3500", "Ram", 2023, "GHI-789", 55000, Availability.FOR_SALE, 1000, UsedState.NEW, 2500, 2, true, true));
//        vehicles.add(new Truck("Tundra", "Toyota", 2020, "JKL-321", 42000, Availability.SOLD, 30000, UsedState.USED, 1200, 2, false, false));
//        vehicles.add(new Truck("Titan XD", "Nissan", 2021, "MNO-654", 46000, Availability.FOR_SALE, 15000, UsedState.USED, 1800, 2, false, true));
//        vehicles.add(new Truck("Sierra 3500HD", "GMC", 2022, "PQR-987", 52000, Availability.FOR_SALE, 4000, UsedState.NEW, 3000, 2, true, true));
//        vehicles.add(new Truck("Actros 1845", "Mercedes-Benz", 2019, "STU-112", 90000, Availability.SOLD, 80000, UsedState.USED, 18000, 3, true, true));
//        vehicles.add(new Truck("FH16", "Volvo", 2020, "VWX-334", 95000, Availability.FOR_SALE, 60000, UsedState.USED, 20000, 3, true, true));
//        vehicles.add(new Truck("TGX", "MAN", 2021, "YZA-556", 97000, Availability.FOR_SALE, 30000, UsedState.USED, 19000, 3, true, true));
//        vehicles.add(new Truck("R500", "Scania", 2022, "BCD-778", 98000, Availability.FOR_SALE, 10000, UsedState.NEW, 18500, 3, true, true));
//        vehicles.add(new Truck("T680", "Kenworth", 2023, "EFG-990", 100000, Availability.FOR_SALE, 5000, UsedState.NEW, 17000, 3, true, true));
//        vehicles.add(new Truck("579", "Peterbilt", 2022, "HIJ-223", 99500, Availability.SOLD, 15000, UsedState.USED, 17500, 3, true, true));
//        vehicles.add(new Truck("NPR-HD", "Isuzu", 2020, "KLM-445", 40000, Availability.FOR_SALE, 25000, UsedState.USED, 3500, 2, false, false));
//        vehicles.add(new Truck("268", "Hino", 2019, "NOP-667", 42000, Availability.FOR_SALE, 35000, UsedState.USED, 4000, 2, false, false));
//        vehicles.add(new Truck("Cascadia", "Freightliner", 2021, "QRS-889", 97000, Availability.FOR_SALE, 28000, UsedState.USED, 19000, 3, true, true));
//        vehicles.add(new Truck("Anthem", "Mack", 2022, "TUV-101", 98000, Availability.SOLD, 12000, UsedState.NEW, 18000, 3, true, true));
//        vehicles.add(new Truck("Stralis", "Iveco", 2020, "WXY-232", 96000, Availability.FOR_SALE, 45000, UsedState.USED, 19500, 3, true, true));
//        vehicles.add(new Truck("Ranger", "Ford", 2019, "ZAB-454", 39000, Availability.FOR_SALE, 40000, UsedState.USED, 1000, 2, false, false));
//        vehicles.add(new Truck("Colorado", "Chevrolet", 2021, "CDE-676", 41000, Availability.FOR_SALE, 22000, UsedState.USED, 1300, 2, false, false));
//        vehicles.add(new Truck("2500", "Ram", 2022, "FGH-898", 48000, Availability.FOR_SALE, 8000, UsedState.NEW, 2000, 2, false, true));
    }

    /**
     * Camiones por capacidad de carga
     *
     * @Param loadcapacity
     * @return
     */

    @Transactional
    public void addTrucks(){
        List<Truck> vehicles = new ArrayList<>();
        vehicles.add(new Truck("F-150", "Ford", 2022, "ABC-123", 45000, Availability.FOR_SALE, 5000, UsedState.NEW, 1500, 2, false, false));
        vehicles.add(new Truck("Silverado 2500HD", "Chevrolet", 2021, "DEF-456", 47000, Availability.FOR_SALE, 12000, UsedState.USED, 2000, 2, false, true));
        vehicles.add(new Truck("3500", "Ram", 2023, "GHI-789", 55000, Availability.FOR_SALE, 1000, UsedState.NEW, 2500, 2, true, true));
        vehicles.add(new Truck("Tundra", "Toyota", 2020, "JKL-321", 42000, Availability.SOLD, 30000, UsedState.USED, 1200, 2, false, false));
        vehicles.add(new Truck("Titan XD", "Nissan", 2021, "MNO-654", 46000, Availability.FOR_SALE, 15000, UsedState.USED, 1800, 2, false, true));
        vehicles.add(new Truck("Sierra 3500HD", "GMC", 2022, "PQR-987", 52000, Availability.FOR_SALE, 4000, UsedState.NEW, 3000, 2, true, true));
        vehicles.add(new Truck("Actros 1845", "Mercedes-Benz", 2019, "STU-112", 90000, Availability.SOLD, 80000, UsedState.USED, 18000, 3, true, true));
        vehicles.add(new Truck("FH16", "Volvo", 2020, "VWX-334", 95000, Availability.FOR_SALE, 60000, UsedState.USED, 20000, 3, true, true));
        vehicles.add(new Truck("TGX", "MAN", 2021, "YZA-556", 97000, Availability.FOR_SALE, 30000, UsedState.USED, 19000, 3, true, true));
        vehicles.add(new Truck("R500", "Scania", 2022, "BCD-778", 98000, Availability.FOR_SALE, 10000, UsedState.NEW, 18500, 3, true, true));
        vehicles.add(new Truck("T680", "Kenworth", 2023, "EFG-990", 100000, Availability.FOR_SALE, 5000, UsedState.NEW, 17000, 3, true, true));
        vehicles.add(new Truck("579", "Peterbilt", 2022, "HIJ-223", 99500, Availability.SOLD, 15000, UsedState.USED, 17500, 3, true, true));
        vehicles.add(new Truck("NPR-HD", "Isuzu", 2020, "KLM-445", 40000, Availability.FOR_SALE, 25000, UsedState.USED, 3500, 2, false, false));
        vehicles.add(new Truck("268", "Hino", 2019, "NOP-667", 42000, Availability.FOR_SALE, 35000, UsedState.USED, 4000, 2, false, false));
        vehicles.add(new Truck("Cascadia", "Freightliner", 2021, "QRS-889", 97000, Availability.FOR_SALE, 28000, UsedState.USED, 19000, 3, true, true));
        vehicles.add(new Truck("Anthem", "Mack", 2022, "TUV-101", 98000, Availability.SOLD, 12000, UsedState.NEW, 18000, 3, true, true));
        vehicles.add(new Truck("Stralis", "Iveco", 2020, "WXY-232", 96000, Availability.FOR_SALE, 45000, UsedState.USED, 19500, 3, true, true));
        vehicles.add(new Truck("Ranger", "Ford", 2019, "ZAB-454", 39000, Availability.FOR_SALE, 40000, UsedState.USED, 1000, 2, false, false));
        vehicles.add(new Truck("Colorado", "Chevrolet", 2021, "CDE-676", 41000, Availability.FOR_SALE, 22000, UsedState.USED, 1300, 2, false, false));
        vehicles.add(new Truck("2500", "Ram", 2022, "FGH-898", 48000, Availability.FOR_SALE, 8000, UsedState.NEW, 2000, 2, false, true));
        truckRepository.saveAll(vehicles);
    }

    public List<Truck> getTrucksByCapacity(int loadCapacity) {
        List<Truck> allTrucks = truckRepository.findAll();
        return allTrucks.stream()
                .filter(t -> t.getLoadCapacity() >= loadCapacity)
                .collect(Collectors.toList());
    }

    /**
     * Camiones por número de ejes
     *
     * @param numberOfAxles
     * @return
     */

    public List<Truck> getTrucksByAxles(int numberOfAxles) {
        List<Truck> allTrucks = truckRepository.findAll();
        return allTrucks.stream()
                .filter(t -> t.getNumberOfAxles() == numberOfAxles)
                .collect(Collectors.toList());
    }

    /**
     * Camiones por permiso necesario
     *
     * @param specialPermitRequired
     * @return
     */

    public List<Truck> getTrucksBySpecialPermitRequired(String specialPermitRequired) {
        List<Truck> allTrucks = truckRepository.findAll();

        return allTrucks.stream()
                .filter(t -> t.isSpecialPermitRequired() == validateBool(specialPermitRequired))
                .collect(Collectors.toList());
    }

    public List<Truck> getTrucksByHasTowingSystem(String hasTowingSystem) {
        List<Truck> allTrucks = truckRepository.findAll();


        return allTrucks.stream()
                .filter(t -> t.isHasTowingSystem() == validateBool(hasTowingSystem))
                .collect(Collectors.toList());
    }

    public boolean validateBool(String word) {
        return Boolean.parseBoolean(word.toLowerCase());
    }
}

