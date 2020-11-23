package hu.bme.vik.ambrustorok.vehicleservice.vehicle.service;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleRepository;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineRepository;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionRepository;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleServiceImpl {

    private final VehicleRepository repository;
    private final EngineRepository engineRepository;
    private final OptionRepository optionRepository;
    private final OptionVehicleRepository optionVehicleRepository;

    @PostConstruct
    public void mock() {
        VehicleEntity entity1 = new VehicleEntity();
        VehicleEntity entity2 = new VehicleEntity();
        VehicleEntity entity3 = new VehicleEntity();

        entity1.setId(UUID.fromString("6060fdbb-919c-4157-bc5a-c5ca858a44ae"));
        entity1.setPrice(5000);
        entity1.setNumberOfDoors(4);
        entity1.setLength(5);
        entity1.setManufacturer("Audi");
        entity1.setModel("A4");
        entity1.setStyle(EStyle.Sedan);
        entity1.setWeight(1900);
        entity1.setWidth(2.2);
        entity1.setWarranty(3);

        entity2.setId(UUID.fromString("d5d4eab0-9cd4-4442-ae85-85f439136015"));
        entity2.setPrice(6500);
        entity2.setNumberOfDoors(4);
        entity2.setLength(5);
        entity2.setManufacturer("BMW");
        entity2.setModel("Series 5");
        entity2.setStyle(EStyle.Wagon);
        entity2.setWeight(2100);
        entity2.setWidth(2.2);
        entity2.setWarranty(3);

        entity3.setId(UUID.fromString("a8d4eab0-9cd4-4442-ae85-85f439136015"));
        entity3.setPrice(7500);
        entity3.setNumberOfDoors(5);
        entity3.setLength(2);
        entity3.setManufacturer("Audi");
        entity3.setModel("A7");
        entity3.setStyle(EStyle.Coupe);
        entity3.setWeight(2700);
        entity3.setWidth(2.2);
        entity3.setWarranty(3);

        repository.save(entity1);
        repository.save(entity2);
        repository.save(entity3);

        List<EngineEntity> engines = engineRepository.findAll();
        entity1.setEngines(engines);
        entity2.setEngines(engines);
        entity3.setEngines(engines);
        engines.forEach(engine -> engine.setVehicles(Stream.of(entity1, entity2, entity3).collect(Collectors.toSet())));

        List<OptionEntity> options = new ArrayList<>(optionRepository.findAll());

        addOption(entity1, options.get(0), 500);
        addOption(entity2, options.get(0), 1000);
        addOption(entity2, options.get(1), 1500);
        addOption(entity3, options.get(1), 2000);

        engineRepository.saveAll(engines);
        //optionRepository.saveAll(options);
        repository.save(entity1);
        repository.save(entity2);
        repository.save(entity3);
    }

    public void addOption(VehicleEntity vehicleEntity, OptionEntity optionEntity, double price)
    {
        OptionVehicleEntity optionVehicleEntity = new OptionVehicleEntity(optionEntity, vehicleEntity);
        optionVehicleEntity.setPrice(price);
        vehicleEntity.getOptions().add(optionVehicleEntity);
        optionEntity.getVehicles().add(optionVehicleEntity);
        optionVehicleRepository.save(optionVehicleEntity);
    }

//    @PreDestroy
    public void reset() {
        repository.deleteAll();
    }

    public Optional<VehicleEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public Collection<VehicleEntity> findAll() {
        return repository.findAll();
    }

    public Collection<String> findManufacturers() {
        return repository.findManufacturers();
    }

    public Collection<String> findModelsByManufacturer(String manufacturer) {
        return repository.findModelsByManufacturer(manufacturer);
    }
    public Collection<VehicleEntity> fetchWithOptions() {
        return repository.fetchWithOptions();
    }

//    public Collection<OptionResponseNoPrice> findOptionsByManufacturer(String manufacturer) {
//        var list = repository.findOptionsByManufacturer(manufacturer);
//        return list.stream().map(optionResponse -> new OptionResponseNoPrice(optionResponse.getName(), optionResponse.getValue())).distinct().collect(Collectors.toList());
//    }

    public VehicleEntity create(VehicleRequest dto) {
        log.debug("Creating new Vehicle {}", dto);

        VehicleEntity entity = new VehicleEntity();

        entity.setPrice(dto.getPrice());
        entity.setNumberOfDoors(dto.getNumberOfDoors());
        entity.setLength(dto.getLength());
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setStyle(dto.getStyle());
        entity.setWeight(dto.getWeight());
        entity.setWidth(dto.getWidth());
        entity.setWarranty(dto.getWarranty());

        return repository.save(entity);
    }

    public VehicleEntity update(UUID id, VehicleResponse dto) {
        VehicleEntity entity = repository.getOne(id);
        entity.setPrice(dto.getPrice());
        entity.setNumberOfDoors(dto.getNumberOfDoors());
        entity.setLength(dto.getLength());
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setStyle(dto.getStyle());
        entity.setWeight(dto.getWeight());
        entity.setWidth(dto.getWidth());
        entity.setWarranty(dto.getWarranty());

        return repository.save(entity);

    }

    public boolean delete(UUID id) {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
        }
        return exists;
    }


}
