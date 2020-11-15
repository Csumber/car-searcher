package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleDTO EntityToDTO(VehicleEntity entity);
}
