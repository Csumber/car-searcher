package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineInVehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionInVehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.connector.EngineVehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.presentation.EngineMapper;
import hu.bme.vik.ambrustorok.vehicleservice.option.connector.OptionVehicleEntity;
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
    @Named("optionVehicleEntityListToOptionInVehicleResponseCollection")
    static Collection<OptionInVehicleResponse> optionVehicleEntityListToOptionInVehicleResponseCollection(List<OptionVehicleEntity> list) {
        if (list == null) {
            return null;
        }
        Collection<OptionInVehicleResponse> collection = new ArrayList<OptionInVehicleResponse>(list.size());
        for (OptionVehicleEntity optionVehicleEntity : list) {
            OptionInVehicleResponse optionInVehicleResponse = new OptionInVehicleResponse();
            optionInVehicleResponse.setPrice(optionVehicleEntity.getPrice());
            optionInVehicleResponse.setId(optionVehicleEntity.getOptionEntity().getId());
            optionInVehicleResponse.setName(optionVehicleEntity.getOptionEntity().getName());
            optionInVehicleResponse.setValue(optionVehicleEntity.getOptionEntity().getValue());
            collection.add(optionInVehicleResponse);

        }

        return collection;
    }

    @Named("engineVehicleEntityListToEngineInVehicleResponseCollection")
    static Collection<EngineInVehicleResponse> engineVehicleEntityListToEngineInVehicleResponseCollection(List<EngineVehicleEntity> list) {
        if (list == null) {
            return null;
        }
        Collection<EngineInVehicleResponse> collection = new ArrayList<EngineInVehicleResponse>(list.size());
        for (EngineVehicleEntity engineVehicleEntity : list) {
            EngineInVehicleResponse engineInVehicleResponse = new EngineInVehicleResponse();
            engineInVehicleResponse.setPrice(engineVehicleEntity.getPrice());
            engineInVehicleResponse.setId(engineVehicleEntity.getEngineEntity().getId());
            engineInVehicleResponse.setConsumption(engineVehicleEntity.getEngineEntity().getConsumption());
            engineInVehicleResponse.setCylinderCapacity(engineVehicleEntity.getEngineEntity().getCylinderCapacity());
            engineInVehicleResponse.setFuel(engineVehicleEntity.getEngineEntity().getFuel());
            engineInVehicleResponse.setHorsepower(engineVehicleEntity.getEngineEntity().getHorsepower());
            engineInVehicleResponse.setTransmission(engineVehicleEntity.getEngineEntity().getTransmission());

            collection.add(engineInVehicleResponse);

        }

        return collection;
    }

    @Mapping(source = "options", target = "options", qualifiedByName = "optionVehicleEntityListToOptionInVehicleResponseCollection")
    @Mapping(source = "engines", target = "engines", qualifiedByName = "engineVehicleEntityListToEngineInVehicleResponseCollection")
    VehicleResponse EntityToDTO(VehicleEntity entity);
}
