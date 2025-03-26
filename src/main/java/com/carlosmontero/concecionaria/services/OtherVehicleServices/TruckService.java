package com.carlosmontero.concecionaria.services.OtherVehicleServices;

import com.carlosmontero.concecionaria.models.OtherVehiclesModels.Truck;
import com.carlosmontero.concecionaria.repository.TruckRepository;
import com.carlosmontero.concecionaria.services.AbstractVehicleServices.VehicleServiceImpl;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TruckService extends VehicleServiceImpl<Truck, TruckRepository> {

    private TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        super(truckRepository);
        this.truckRepository = truckRepository;
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


    public Truck createTruck(Truck truck){
        return truckRepository.save(truck);
    }

    public Optional<Truck> updateTruck(Long id, Truck updatedData){
        return truckRepository.findById(id).map(truck -> {
            BeanUtils.copyProperties(updatedData,truck,"id");
            return truckRepository.save(truck);
        });
    }
}

