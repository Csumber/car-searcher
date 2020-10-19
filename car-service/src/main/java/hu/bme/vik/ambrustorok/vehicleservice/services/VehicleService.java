package hu.bme.vik.ambrustorok.vehicleservice.services;

import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;

import java.util.List;

public interface VehicleService {
    List<Vehicle> listAll();

    Vehicle getById(String id);

    Vehicle saveOrUpdate(Vehicle product);

    void delete(String id);

    List<String> getAllManufacturers();

    List<String> getAllModels(String manufacturer);

    List<SearchResult> search(SearchRequest searchRequest);

    List<Option> getAllFacets(String manufacturer, String model);

    List<Vehicle> getallVehicles();
}
