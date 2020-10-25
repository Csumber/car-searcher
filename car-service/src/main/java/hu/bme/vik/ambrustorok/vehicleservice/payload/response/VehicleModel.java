package hu.bme.vik.ambrustorok.vehicleservice.payload.response;

public class VehicleModel {
    private String manufacturer;

    private String model;
    public VehicleModel(){

    }

    public VehicleModel(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
