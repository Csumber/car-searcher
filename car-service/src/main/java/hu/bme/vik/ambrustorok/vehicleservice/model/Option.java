package hu.bme.vik.ambrustorok.vehicleservice.model;

import javax.validation.constraints.NotBlank;

// For example
// Air conditioning
// Automatic: $1200.00
// Manual: $500.00

//when adding a new car, you can choose from already existing facets

public class Option {

    @NotBlank
    String name;

    @NotBlank
    String value;

    @NotBlank
    int price;

    public Option() {
    }

    public Option(@NotBlank String name, @NotBlank String value, @NotBlank int price) {
        this.name = name;
        this.value = value;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
