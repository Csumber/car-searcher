package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineDTO EntityToDTO(EngineEntity entity);
}
