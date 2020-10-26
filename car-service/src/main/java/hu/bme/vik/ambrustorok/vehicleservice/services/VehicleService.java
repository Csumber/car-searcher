package hu.bme.vik.ambrustorok.vehicleservice.services;

import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;

import java.util.List;

public interface VehicleService {

    public List<String> getManufacturers();

    public List<String> getModelsOfManufacturer(String manufacturer);

    // <========================================================

    public List<OptionResponse> getOptions();

    public List<OptionResponse> getManufacturerOptions(String manufacturer);

    public List<OptionResponse> getModelOptions(String manufacturer, String model);

    // <========================================================

    public List<Vehicle> getVehicles();

    public List<Vehicle> getManufacturerVehicles(String manufacturer);

    public List<Vehicle> getModelVehicles(String manufacturer, String Model);

    // <========================================================

    public List<EngineResponse> getEngines();

    public List<EngineResponse> getManufacturerEngines(String manufacturer);

    public List<EngineResponse> getModelEngines(String manufacturer, String model);

    // <========================================================

    public List<SearchResult> search(SearchRequest searchRequest);

    public Vehicle getById(String id);

    public Vehicle saveOrUpdate(Vehicle vehicle);

    public void delete(String id);

    public void delete(Vehicle vehicle);
}
