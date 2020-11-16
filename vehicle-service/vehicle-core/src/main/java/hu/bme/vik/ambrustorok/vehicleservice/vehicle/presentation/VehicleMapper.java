package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.engine.presentation.EngineMapper;
import hu.bme.vik.ambrustorok.vehicleservice.option.presentation.OptionMapper;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EngineMapper.class, OptionMapper.class})
public interface VehicleMapper {
    VehicleDTO EntityToDTO(VehicleEntity entity);
}
