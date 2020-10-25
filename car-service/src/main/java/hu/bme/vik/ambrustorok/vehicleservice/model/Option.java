package hu.bme.vik.ambrustorok.vehicleservice.model;

import javax.validation.constraints.NotBlank;

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
