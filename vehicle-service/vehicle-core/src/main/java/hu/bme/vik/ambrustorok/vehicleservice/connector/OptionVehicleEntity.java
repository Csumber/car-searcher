package hu.bme.vik.ambrustorok.vehicleservice.connector;

import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OptionVehicleEntity {

    @EmbeddedId
    private OptionVehicleId id;

    @ManyToOne
    @MapsId("optionId")
    private OptionEntity optionEntity;

    @ManyToOne
    @MapsId("vehicleId")
    private VehicleEntity vehicleEntity;

    @Column(nullable = false)
    private double price;

    public OptionVehicleEntity(OptionEntity optionEntity, VehicleEntity vehicleEntity) {
        this.optionEntity = optionEntity;
        this.vehicleEntity = vehicleEntity;
        this.id = new OptionVehicleId(optionEntity.getId(), vehicleEntity.getId());
    }
}