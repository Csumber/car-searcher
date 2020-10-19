package hu.bme.vik.ambrustorok.vehicleservice.model;

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
    private String transmission;

    @NotBlank
    private int average_consumption;

    @NotBlank
    private int cylinder_capacity;

    @NotBlank
    private int price;

    public Engine() {
    }

    public Engine(String id, @NotBlank int horsepower, @NotBlank String fuel, @NotBlank String transmission, @NotBlank int average_consumption, @NotBlank int cylinder_capacity, @NotBlank int price) {
        this.id = id;
        this.horsepower = horsepower;
        this.fuel = fuel;
        this.transmission = transmission;
        this.average_consumption = average_consumption;
        this.cylinder_capacity = cylinder_capacity;
        this.price = price;
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getCylinder_capacity() {
        return cylinder_capacity;
    }

    public void setCylinder_capacity(int cylinder_capacity) {
        this.cylinder_capacity = cylinder_capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAverage_consumption() {
        return average_consumption;
    }

    public void setAverage_consumption(int average_consumption) {
        this.average_consumption = average_consumption;
    }
}
