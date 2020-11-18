package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-16T12:30:02+0100",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class EngineMapperImpl implements EngineMapper {

    @Override
    public EngineResponse EntityToDTO(EngineEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EngineResponse engineDTO = new EngineResponse();

        engineDTO.setId( entity.getId() );
        engineDTO.setConsumption( entity.getConsumption() );
        engineDTO.setCylinderCapacity( entity.getCylinderCapacity() );
        engineDTO.setFuel( entity.getFuel() );
        engineDTO.setTransmission( entity.getTransmission() );
        engineDTO.setHorsepower( entity.getHorsepower() );
        engineDTO.setPrice( entity.getPrice() );

        return engineDTO;
    }
}
