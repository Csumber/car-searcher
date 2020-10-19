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
    String priceOfValue;

    public Facet() {
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
}
