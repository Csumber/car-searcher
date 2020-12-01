package hu.bme.vik.ambrustorok.vehicleservice.dto.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionInVehicleResponse {

    @NotNull
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String value;

    @NotNull
    @NotEmpty
    private double price;

    public boolean equals(OptionResponse o) {
        return Objects.equals(name, o.getName()) &&
                Objects.equals(value, o.getValue());
    }
}

