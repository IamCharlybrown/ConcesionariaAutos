package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Motorcycle;
import com.carlosmontero.concecionaria.repository.MotorcycleRepository;
import com.carlosmontero.concecionaria.services.AbstractVehicleServices.VehicleServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MotorcycleService extends VehicleServiceImpl<Motorcycle, MotorcycleRepository> {

    protected MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        super(motorcycleRepository);
        this.motorcycleRepository = motorcycleRepository;

    }

    @Transactional
    public void addMotorcycles() {
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


    public Motorcycle createMotorcycle(Motorcycle motorcycle) {

        return motorcycleRepository.save(motorcycle);
    }


    public List<Motorcycle> searchMotorcycles(String brand, String name, Integer year, Double price,
                                              String availability, Integer milage, String usedState, String type) {

        List<Motorcycle> filteredList = super.searchVehicles(brand, name, year, price, availability, milage, usedState);
        System.out.println(filteredList);

        if (type != null) {
            filteredList.stream()
                    .filter(Motorcycle -> Motorcycle.getMotorcycleType().equalsIgnoreCase(type))
                    .collect(Collectors.toList());
        }

        return filteredList;
    }

    public Optional<Motorcycle> updateMotorcycle(Long id, Motorcycle updatedData){
        return motorcycleRepository.findById(id).map(motorcycle -> {
            BeanUtils.copyProperties(updatedData,motorcycle,"id");
            return motorcycleRepository.save(motorcycle);
        });
    }

    public Optional<Motorcycle> deleteMotorcycle(Long id){
       Optional<Motorcycle> motorcycle = motorcycleRepository.findById(id);
       motorcycle.ifPresent(motorcycleRepository::delete);
       return motorcycle;
    }
}
