package hu.bme.vik.ambrustorok.vehicleservice.connector;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OptionVehicleEntity {

    @EmbeddedId
    private OptionVehicleId id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("optionId")
    private OptionEntity optionEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vehicleId")
    private VehicleEntity vehicleEntity;

    @Column(nullable = false)
    private double price;

    public OptionVehicleEntity(OptionEntity optionEntity, VehicleEntity vehicleEntity) {
        this.optionEntity = optionEntity;
        this.vehicleEntity = vehicleEntity;
        this.id = new OptionVehicleId(optionEntity.getId(), vehicleEntity.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OptionVehicleEntity that = (OptionVehicleEntity) o;
        return Objects.equals(optionEntity, that.optionEntity) &&
                Objects.equals(vehicleEntity, that.vehicleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionEntity, vehicleEntity);
    }
}