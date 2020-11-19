package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-19T01:31:31+0100",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class EngineMapperImpl implements EngineMapper {

    @Override
    public EngineResponse EntityToDTO(EngineEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EngineResponse engineResponse = new EngineResponse();

        engineResponse.setId( entity.getId() );
        engineResponse.setConsumption( entity.getConsumption() );
        engineResponse.setCylinderCapacity( entity.getCylinderCapacity() );
        engineResponse.setFuel( entity.getFuel() );
        engineResponse.setTransmission( entity.getTransmission() );
        engineResponse.setHorsepower( entity.getHorsepower() );
        engineResponse.setPrice( entity.getPrice() );

        return engineResponse;
    }
}
