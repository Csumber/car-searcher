package hu.bme.vik.ambrustorok.vehicleservice.engine.connector;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngineVehicleId implements Serializable {

    @Column
    private UUID engineId;

    @Column
    private UUID vehicleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EngineVehicleId that = (EngineVehicleId) o;
        return Objects.equals(engineId, that.engineId) &&
                Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineId, vehicleId);
    }
}
