package bme.vik.ambrustorok.vehicleservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "engines")
public class Engine {
    @Id
    private String id;

    @NotBlank
    private int horsepower;

    @NotBlank
    private String fuel;

    @NotBlank
    private int cylinder_capacity;

    @NotBlank
    private int price_from_base;

    public Engine() {
    }

    public Engine(@NotBlank int horsepower, @NotBlank String fuel, @NotBlank int cylinder_capacity, @NotBlank int price_from_base) {
        this.horsepower = horsepower;
        this.fuel = fuel;
        this.cylinder_capacity = cylinder_capacity;
        this.price_from_base = price_from_base;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getCylinder_capacity() {
        return cylinder_capacity;
    }

    public void setCylinder_capacity(int cylinder_capacity) {
        this.cylinder_capacity = cylinder_capacity;
    }

    public int getPrice_from_base() {
        return price_from_base;
    }

    public void setPrice_from_base(int price_from_base) {
        this.price_from_base = price_from_base;
    }
}
