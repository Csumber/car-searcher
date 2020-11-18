package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineResponse EntityToDTO(EngineEntity entity);
}
