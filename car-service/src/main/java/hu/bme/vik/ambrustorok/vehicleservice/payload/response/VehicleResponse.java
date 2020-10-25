package hu.bme.vik.ambrustorok.vehicleservice.payload.response;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.model.Style;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class VehicleResponse {
    private String id;

    private String manufacturer;

    private String model;

    private Style style;

    private Set<Engine> engines;

    private Set<Option> options;

    private int base_price;

    private int number_of_doors;

    private int warranty;

    private int weight;

    public VehicleResponse(String id, String manufacturer, String model, Style style, Set<Engine> engines, Set<Option> options, int base_price, int number_of_doors, int warranty, int weight) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.style = style;
        this.engines = engines;
        this.options = options;
        this.base_price = base_price;
        this.number_of_doors = number_of_doors;
        this.warranty = warranty;
        this.weight = weight;
    }

    public VehicleResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Set<Engine> getEngines() {
        return engines;
    }

    public void setEngines(Set<Engine> engines) {
        this.engines = engines;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public int getBase_price() {
        return base_price;
    }

    public void setBase_price(int base_price) {
        this.base_price = base_price;
    }

    public int getNumber_of_doors() {
        return number_of_doors;
    }

    public void setNumber_of_doors(int number_of_doors) {
        this.number_of_doors = number_of_doors;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
