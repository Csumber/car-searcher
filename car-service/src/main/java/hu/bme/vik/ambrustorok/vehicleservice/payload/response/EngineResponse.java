package hu.bme.vik.ambrustorok.vehicleservice.payload.response;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class EngineResponse {

    private int horsepower;

    private String fuel;

    private String transmission;

    private int average_consumption;

    private int cylinder_capacity;

    private int price;

    public EngineResponse() {
    }

    public EngineResponse(int horsepower, String fuel, String transmission, int average_consumption, int cylinder_capacity, int price) {
        this.horsepower = horsepower;
        this.fuel = fuel;
        this.transmission = transmission;
        this.average_consumption = average_consumption;
        this.cylinder_capacity = cylinder_capacity;
        this.price = price;
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

    public int getAverage_consumption() {
        return average_consumption;
    }

    public void setAverage_consumption(int average_consumption) {
        this.average_consumption = average_consumption;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineResponse that = (EngineResponse) o;
        return horsepower == that.horsepower &&
                average_consumption == that.average_consumption &&
                cylinder_capacity == that.cylinder_capacity &&
                price == that.price &&
                Objects.equals(fuel, that.fuel) &&
                Objects.equals(transmission, that.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsepower, fuel, transmission, average_consumption, cylinder_capacity, price);
    }
}
