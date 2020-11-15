package hu.bme.vik.ambrustorok.vehicleservice.option.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.option.OptionDTO;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    OptionDTO EntityToDTO(OptionEntity entity);
}
