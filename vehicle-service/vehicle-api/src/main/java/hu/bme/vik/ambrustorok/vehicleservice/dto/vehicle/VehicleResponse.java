package hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {


    Set<EngineResponse> engines;

    Set<OptionResponse> options;

    private double price;

    private int numberOfDoors;

    private double length;

    private String manufacturer;

    private String model;

    private EStyle style;

    private double weight;

    private double width;

    private int warranty;
}
