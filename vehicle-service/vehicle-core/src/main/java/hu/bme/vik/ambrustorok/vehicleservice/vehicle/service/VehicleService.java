package hu.bme.vik.ambrustorok.vehicleservice.vehicle.service;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineRepository;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {

    private VehicleRepository repository;
    private EngineRepository engineRepository;

    @PostConstruct
    public void mock() {
        VehicleEntity entity1 = new VehicleEntity();
        VehicleEntity entity2 = new VehicleEntity();

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

        List<EngineEntity> engines = engineRepository.findAll();

        entity1.setEngines(new HashSet<>(engines));
        entity2.setEngines(new HashSet<>(engines));
        engines.forEach(engine -> engine.setVehicles(Stream.of(entity1,entity2).collect(Collectors.toSet())));

        engineRepository.saveAll(engines);
        repository.save(entity1);
        repository.save(entity2);
    }

    @PreDestroy
    public void reset() {
        repository.deleteAll();
    }

    public Page<VehicleEntity> findAll(Pageable pageable) {
//        return repository.findAll(pageable);
        List<VehicleEntity> list = repository.fetchAllJoinEngines();
        return new PageImpl<>(list, pageable, list.size());
    }

    public Optional<VehicleEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public VehicleEntity create(VehicleRegisterDTO dto) {
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

    public VehicleEntity update(UUID id, VehicleDTO dto) {
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
