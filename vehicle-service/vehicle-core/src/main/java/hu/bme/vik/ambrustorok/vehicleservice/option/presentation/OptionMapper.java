package hu.bme.vik.ambrustorok.vehicleservice.option.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.option.connector.OptionVehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.connector.OptionVehicleId;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionInVehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    OptionResponse EntityToDTO(OptionEntity entity);
    OptionEntity VEntityToEntity(OptionVehicleEntity entity);
    OptionInVehicleResponse EntityToVDTO(OptionEntity entity);
    UUID map(OptionVehicleId value);
}
