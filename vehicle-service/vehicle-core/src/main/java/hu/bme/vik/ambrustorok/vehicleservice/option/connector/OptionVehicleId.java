package hu.bme.vik.ambrustorok.vehicleservice.option.connector;

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
public class OptionVehicleId implements Serializable {

    @Column
    private UUID optionId;

    @Column
    private UUID vehicleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OptionVehicleId that = (OptionVehicleId) o;
        return Objects.equals(optionId, that.optionId) &&
                Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionId, vehicleId);
    }
}
