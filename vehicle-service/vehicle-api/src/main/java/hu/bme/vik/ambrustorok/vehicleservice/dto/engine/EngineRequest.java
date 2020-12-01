package hu.bme.vik.ambrustorok.vehicleservice.dto.engine;

import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineRequest {

    private double consumption;

    private int cylinderCapacity;

    private EFuel fuel;

    private ETransmission transmission;

    private int horsepower;

    private double price;
}
