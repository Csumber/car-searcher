package hu.bme.vik.ambrustorok.vehicleservice.payload.request;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;

import javax.validation.constraints.NotBlank;

public class VehicleRequest {
    private String manufacturer;

    private String type;

    public VehicleRequest(String manufacturer, String type) {
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public VehicleRequest() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
