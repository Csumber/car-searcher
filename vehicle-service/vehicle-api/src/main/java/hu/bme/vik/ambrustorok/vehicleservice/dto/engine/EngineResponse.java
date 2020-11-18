package hu.bme.vik.ambrustorok.vehicleservice.dto.engine;


import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineResponse {

    @NotNull
    private UUID id;

    @NotNull
    @NotEmpty
    private double consumption;

    @NotNull
    @NotEmpty
    private int cylinderCapacity;

    @NotNull
    @NotEmpty
    private EFuel fuel;

    @NotNull
    @NotEmpty
    private ETransmission transmission;

    @NotNull
    @NotEmpty
    private int horsepower;

    @NotNull
    @NotEmpty
    private double price;

}
