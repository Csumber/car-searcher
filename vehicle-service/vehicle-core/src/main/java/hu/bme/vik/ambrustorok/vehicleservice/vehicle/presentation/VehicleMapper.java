package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleId;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.presentation.EngineMapper;
import hu.bme.vik.ambrustorok.vehicleservice.option.presentation.OptionMapper;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {EngineMapper.class, OptionMapper.class})
public interface VehicleMapper {
    VehicleResponse EntityToDTO(VehicleEntity entity);
    UUID map(OptionVehicleId value);
}
