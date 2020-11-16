package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-15T14:28:14+0100",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class EngineMapperImpl implements EngineMapper {

    @Override
    public EngineDTO EntityToDTO(EngineEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EngineDTO engineDTO = new EngineDTO();

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
