package hu.bme.vik.ambrustorok.vehicleservice.option.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    OptionResponse EntityToDTO(OptionEntity entity);
}
