package hu.bme.vik.ambrustorok.vehicleservice.vehicle.service;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {

    private VehicleRepository repository;

    @PostConstruct
    public void mock() {
        VehicleEntity entity1 = new VehicleEntity();
        VehicleEntity entity2 = new VehicleEntity();

        entity1.setBasePrice(5000);
        entity1.setNumberOfDoors(4);
        entity1.setLength(5);
        entity1.setManufacturer("Audi");
        entity1.setModel("A4");
        entity1.setStyle(EStyle.Sedan);
        entity1.setWeight(1900);
        entity1.setWidth(2.2);
        entity1.setWarranty(3);

        entity2.setBasePrice(6500);
        entity2.setNumberOfDoors(4);
        entity2.setLength(5);
        entity2.setManufacturer("BMW");
        entity2.setModel("Series 5");
        entity2.setStyle(EStyle.Wagon);
        entity2.setWeight(2100);
        entity2.setWidth(2.2);
        entity2.setWarranty(3);

        repository.save(entity1);
        repository.save(entity2);

    }

    public Page<VehicleEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<VehicleEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public VehicleEntity create(VehicleRegisterDTO dto) {
        log.debug("Creating new Vehicle {}", dto);

        VehicleEntity entity = new VehicleEntity();

        entity.setBasePrice(dto.getBasePrice());
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
        entity.setBasePrice(dto.getBasePrice());
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
