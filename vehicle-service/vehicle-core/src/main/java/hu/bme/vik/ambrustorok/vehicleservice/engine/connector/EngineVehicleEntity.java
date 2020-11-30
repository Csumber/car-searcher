package hu.bme.vik.ambrustorok.vehicleservice.engine.connector;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
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
public class EngineVehicleEntity {

    @EmbeddedId
    private EngineVehicleId id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("engineId")
    private EngineEntity engineEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vehicleId")
    private VehicleEntity vehicleEntity;

    @Column(nullable = false)
    private double price;

    public EngineVehicleEntity(EngineEntity engineEntity, VehicleEntity vehicleEntity) {
        this.engineEntity = engineEntity;
        this.vehicleEntity = vehicleEntity;
        this.id = new EngineVehicleId(engineEntity.getId(), vehicleEntity.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EngineVehicleEntity that = (EngineVehicleEntity) o;
        return Objects.equals(engineEntity, that.engineEntity) &&
                Objects.equals(vehicleEntity, that.vehicleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineEntity, vehicleEntity);
    }
}