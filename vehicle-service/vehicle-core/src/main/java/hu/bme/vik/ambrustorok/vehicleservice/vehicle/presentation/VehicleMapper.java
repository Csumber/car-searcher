package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionInVehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.presentation.EngineMapper;
import hu.bme.vik.ambrustorok.vehicleservice.option.presentation.OptionMapper;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EngineMapper.class, OptionMapper.class})
public interface VehicleMapper {
    @Mapping(source = "options", target = "options", qualifiedByName = "optionVehicleEntityListToOptionInVehicleResponseCollection")
    VehicleResponse EntityToDTO(VehicleEntity entity);

    @Named("optionVehicleEntityListToOptionInVehicleResponseCollection")
    static Collection<OptionInVehicleResponse> optionVehicleEntityListToOptionInVehicleResponseCollection(List<OptionVehicleEntity> list) {
        if ( list == null ) {
            return null;
        }
        Collection<OptionInVehicleResponse> collection = new ArrayList<OptionInVehicleResponse>( list.size() );
        for ( OptionVehicleEntity optionVehicleEntity : list ) {
            OptionInVehicleResponse optionInVehicleResponse = new OptionInVehicleResponse();
            optionInVehicleResponse.setPrice(optionVehicleEntity.getPrice());
            optionInVehicleResponse.setId(optionVehicleEntity.getOptionEntity().getId());
            optionInVehicleResponse.setName(optionVehicleEntity.getOptionEntity().getName());
            optionInVehicleResponse.setValue(optionVehicleEntity.getOptionEntity().getValue());
            collection.add(optionInVehicleResponse);

        }

        return collection;
    }
}
