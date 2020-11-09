package hu.bme.vik.ambrustorok.vehicleservice.engine.service;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.engine.ETransmission;
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
        EngineEntity engineEntity = new EngineEntity();

        engineEntity.setConsumption(69.420);
        engineEntity.setCylinderCapacity(1955);
        engineEntity.setFuel(EFuel.Diesel);
        engineEntity.setTransmission(ETransmission.Manual);
        engineEntity.setHorsepower(500);
        engineEntity.setPrice(1500);
        engineEntity.setId(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64"));
        repository.save(engineEntity);
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
        entity.setPrice(entity.getPrice());

        return repository.save(entity);
    }
}
