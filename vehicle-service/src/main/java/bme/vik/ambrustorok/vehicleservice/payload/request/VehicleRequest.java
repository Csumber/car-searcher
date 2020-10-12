package bme.vik.ambrustorok.vehicleservice.payload.request;

import bme.vik.ambrustorok.vehicleservice.model.Engine;

import javax.validation.constraints.NotBlank;

public class VehicleRequest {
    @NotBlank
    private String manufacturer;

    @NotBlank
    private String type;

    @NotBlank
    private String model;

    @NotBlank
    private Engine engine;

    @NotBlank
    private boolean ac_available;

    @NotBlank
    private int ac_price_if_availabe;

    @NotBlank
    private boolean esp_available;

    @NotBlank
    private int esp_price_if_availabe;

    @NotBlank
    private boolean cruise_control_available;

    @NotBlank
    private int cruise_control_price_if_availabe;

    @NotBlank
    private int base_price;

    @NotBlank
    private int number_of_doors;

    @NotBlank
    private int number_of_seats;

    @NotBlank
    private String gearbox_type;

    @NotBlank
    private String drive;

    @NotBlank
    private int average_consumption;

    @NotBlank
    private int number_of_electric_windows;

    @NotBlank
    private int warranty;

    public VehicleRequest() {}
    public VehicleRequest(@NotBlank String manufacturer, @NotBlank String type, @NotBlank String model, @NotBlank Engine engine, @NotBlank boolean ac_available, @NotBlank int ac_price_if_availabe, @NotBlank boolean esp_available, @NotBlank int esp_price_if_availabe, @NotBlank boolean cruise_control_available, @NotBlank int cruise_control_price_if_availabe, @NotBlank int base_price, @NotBlank int number_of_doors, @NotBlank int number_of_seats, @NotBlank String gearbox_type, @NotBlank String drive, @NotBlank int average_consumption, @NotBlank int number_of_electric_windows, @NotBlank int warranty) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.model = model;
        this.engine = engine;
        this.ac_available = ac_available;
        this.ac_price_if_availabe = ac_price_if_availabe;
        this.esp_available = esp_available;
        this.esp_price_if_availabe = esp_price_if_availabe;
        this.cruise_control_available = cruise_control_available;
        this.cruise_control_price_if_availabe = cruise_control_price_if_availabe;
        this.base_price = base_price;
        this.number_of_doors = number_of_doors;
        this.number_of_seats = number_of_seats;
        this.gearbox_type = gearbox_type;
        this.drive = drive;
        this.average_consumption = average_consumption;
        this.number_of_electric_windows = number_of_electric_windows;
        this.warranty = warranty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public boolean isAc_available() {
        return ac_available;
    }

    public void setAc_available(boolean ac_available) {
        this.ac_available = ac_available;
    }

    public int getAc_price_if_availabe() {
        return ac_price_if_availabe;
    }

    public void setAc_price_if_availabe(int ac_price_if_availabe) {
        this.ac_price_if_availabe = ac_price_if_availabe;
    }

    public boolean isEsp_available() {
        return esp_available;
    }

    public void setEsp_available(boolean esp_available) {
        this.esp_available = esp_available;
    }

    public int getEsp_price_if_availabe() {
        return esp_price_if_availabe;
    }

    public void setEsp_price_if_availabe(int esp_price_if_availabe) {
        this.esp_price_if_availabe = esp_price_if_availabe;
    }

    public boolean isCruise_control_available() {
        return cruise_control_available;
    }

    public void setCruise_control_available(boolean cruise_control_available) {
        this.cruise_control_available = cruise_control_available;
    }

    public int getCruise_control_price_if_availabe() {
        return cruise_control_price_if_availabe;
    }

    public void setCruise_control_price_if_availabe(int cruise_control_price_if_availabe) {
        this.cruise_control_price_if_availabe = cruise_control_price_if_availabe;
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

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getGearbox_type() {
        return gearbox_type;
    }

    public void setGearbox_type(String gearbox_type) {
        this.gearbox_type = gearbox_type;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public int getAverage_consumption() {
        return average_consumption;
    }

    public void setAverage_consumption(int average_consumption) {
        this.average_consumption = average_consumption;
    }

    public int getNumber_of_electric_windows() {
        return number_of_electric_windows;
    }

    public void setNumber_of_electric_windows(int number_of_electric_windows) {
        this.number_of_electric_windows = number_of_electric_windows;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
}
