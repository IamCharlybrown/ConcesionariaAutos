package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.MasterVehicleModel.Vehicle;
import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Car;
import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Motorcycle;
import com.carlosmontero.concecionaria.repository.CarRepository;
import com.carlosmontero.concecionaria.repository.MotorcycleRepository;
import com.carlosmontero.concecionaria.repository.VehicleRepository;
import com.carlosmontero.concecionaria.services.MasterVehicleServices.VehicleServiceImpl;
import com.carlosmontero.concecionaria.utils.Availability;
import com.carlosmontero.concecionaria.utils.MotorcycleType;
import com.carlosmontero.concecionaria.utils.UsedState;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MotorcycleService extends VehicleServiceImpl<Motorcycle, MotorcycleRepository> {

    protected MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        super(motorcycleRepository);
        this.motorcycleRepository = motorcycleRepository;

    }
    @Transactional
    public void addMotorcycles(){
        List<Motorcycle> vehicles = new ArrayList<>();

    }
//    }
    /**
     * Servicio para retornar tipo de motos
     *
     * @param motorcycleType
     * @return
     */

    public List<Motorcycle> getMotorcycleByType(String motorcycleType) {

        List<Motorcycle> allVehicles = motorcycleRepository.findAll();

        return allVehicles.stream()
                .filter(Motorcycle -> Motorcycle.getMotorcycleType().equalsIgnoreCase(motorcycleType))
                .collect(Collectors.toList());
    }

    public List<Motorcycle> searchMotorcycles(String brand, String name, Integer year, Double price,
                                              String availability, Integer milage, String usedState, String type) {

        List<Motorcycle> filteredList = super.searchVehicles(brand, name, year, price, availability, milage, usedState);

        return filteredList.stream()
                .filter(Motorcycle -> Motorcycle.getMotorcycleType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
