package hu.bme.vik.ambrustorok.vehicleservice.option.service;

import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class OptionServiceImpl {

    private final OptionRepository repository;

//    @PostConstruct
    public void mock() {
        OptionEntity entity1 = new OptionEntity();
        OptionEntity entity2 = new OptionEntity();

        entity1.setId(UUID.fromString("61638f8c-8e62-4a76-8fab-4e1650f9e1cb"));
        entity1.setName("AC");
        entity1.setValue("Automatic");

        entity2.setId(UUID.fromString("c885829c-8c4b-4413-96f6-34c3d9f70ab5"));
        entity2.setName("AC");
        entity2.setValue("Manual");

        repository.save(entity1);
        repository.save(entity2);
    }

    //    @PreDestroy
    public void reset() {
        repository.deleteAll();
    }

    public Collection<OptionEntity> findAll() {
        return repository.findAll();
    }

    public Optional<OptionEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public OptionEntity create(OptionRequest dto) {

        OptionEntity entity = new OptionEntity();
        entity.setName((dto.getName()));
        entity.setValue(dto.getValue());

        return repository.save(entity);
    }

    public List<OptionEntity> getOptionsByVehicle(UUID id) {
        return repository.getOptionsByVehicle(id).get().getOptions().stream().map(v -> v.getOptionEntity()).collect(Collectors.toList());
    }

    public OptionEntity update(UUID id, OptionResponse dto) {
        OptionEntity entity = repository.getOne(id);
        entity.setName((dto.getName()));
        entity.setValue(dto.getValue());

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

