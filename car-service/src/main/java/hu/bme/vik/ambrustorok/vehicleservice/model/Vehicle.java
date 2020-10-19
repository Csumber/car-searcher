package hu.bme.vik.ambrustorok.vehicleservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Set;

@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private String id;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String model;

    @NotBlank
    private String type;

    @NotBlank
    private Set<Engine> engines;

    private Set<Option> options;

    @NotBlank
    private int base_price;

    @NotBlank
    private int number_of_doors;

    @NotBlank
    private int warranty;

    public Vehicle(String id, @NotBlank String manufacturer, @NotBlank String model, @NotBlank String type, @NotBlank Set<Engine> engines, Set<Option> options, @NotBlank int base_price, @NotBlank int number_of_doors, @NotBlank int warranty, @NotBlank int weight) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.engines = engines;
        this.options = options;
        this.base_price = base_price;
        this.number_of_doors = number_of_doors;
        this.warranty = warranty;
        this.weight = weight;
    }

    @NotBlank
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vehicle() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Engine> getEngines() {
        return engines;
    }

    public void setEngines(Set<Engine> engines) {
        this.engines = engines;
    }

    public Set<Option>  getOptions() {
        return options;
    }

    public void setOptions(Set<Option>  options) {
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
}
