package hu.bme.vik.ambrustorok.vehicleservice.model;

import javax.validation.constraints.NotBlank;

// For example
// Air conditioning
// Automatic: $1200.00
// Manual: $500.00

public class Facet {

    @NotBlank
    String type;

    @NotBlank
    String value;

    @NotBlank
    String price;

    public Facet() {
    }

    public Facet(@NotBlank String type, @NotBlank String value, @NotBlank String price) {
        this.type = type;
        this.value = value;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
