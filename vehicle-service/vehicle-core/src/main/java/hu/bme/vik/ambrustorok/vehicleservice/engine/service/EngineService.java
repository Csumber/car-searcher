package hu.bme.vik.ambrustorok.vehicleservice.engine.service;

import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineRepository;
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
public class EngineService {

    private EngineRepository repository;

    @PostConstruct
    public void mock() {
        EngineEntity entity1 = new EngineEntity();
        EngineEntity entity2 = new EngineEntity();

        entity1.setConsumption(69.420);
        entity1.setCylinderCapacity(1955);
        entity1.setFuel(EFuel.Diesel);
        entity1.setTransmission(ETransmission.Manual);
        entity1.setHorsepower(500);
        entity1.setPrice(1500);
        repository.save(entity1);

        entity2.setConsumption(50);
        entity2.setCylinderCapacity(2455);
        entity2.setFuel(EFuel.Gasoline);
        entity2.setTransmission(ETransmission.Automatic);
        entity2.setHorsepower(650);
        entity2.setPrice(2000);
        repository.save(entity2);
    }

    public Page<EngineEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<EngineEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public EngineEntity create(EngineRegisterDTO dto) {
        log.debug("Creating new Engine {}", dto);

        EngineEntity entity = new EngineEntity();
        entity.setConsumption(dto.getConsumption());
        entity.setCylinderCapacity(dto.getCylinderCapacity());
        entity.setFuel(dto.getFuel());
        entity.setTransmission(dto.getTransmission());
        entity.setHorsepower(dto.getHorsepower());
        entity.setPrice(dto.getPrice());

        return repository.save(entity);
    }

    public EngineEntity update(UUID id, EngineDTO dto) {
        EngineEntity entity = repository.getOne(id);
        entity.setConsumption(dto.getConsumption());
        entity.setCylinderCapacity(dto.getCylinderCapacity());
        entity.setFuel(dto.getFuel());
        entity.setTransmission(dto.getTransmission());
        entity.setHorsepower(dto.getHorsepower());
        entity.setPrice(dto.getPrice());
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
