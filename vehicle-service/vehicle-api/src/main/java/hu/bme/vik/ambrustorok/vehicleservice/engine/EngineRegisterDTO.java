package hu.bme.vik.ambrustorok.vehicleservice.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineRegisterDTO {

    private double consumption;

    private int cylinderCapacity;

    private EFuel fuel;

    private ETransmission transmission;

    private int horsepower;

    private double price;
}
