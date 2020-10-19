package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.model.Facet;
import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;
import hu.bme.vik.ambrustorok.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/manufacturers")
    @ResponseBody
    public List<String> getAllManufacturers() {
        return vehicleService.getAllManufacturers();
    }

    @GetMapping("/manufacturers/{manufacturer}")
    @ResponseBody
    public List<String> getAllModelsOfManufacturer(@RequestParam String manufacturer) {
        return vehicleService.getAllModels(manufacturer);
    }

    @GetMapping("/manufacturers/{manufacturer}/{model}")
    @ResponseBody
    public List<Facet> getAllModelsOfManufacturer(@RequestParam String manufacturer, @RequestParam String model) {
        return vehicleService.getAllFacets(manufacturer, model);
    }

    @PostMapping("/search")
    @ResponseBody
    public List<SearchResult> search(@RequestBody SearchRequest searchRequest) {
        //TODO do not save in searchDB
        return vehicleService.search(searchRequest);
    }

    // <=============================================

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getallVehicles();
    }

    @PostMapping("/vehicles")
    public String addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return "Adding new vehicle....";
    }

    @PutMapping("/vehicles")
    public String addFacetToExistingVehicles(@Valid @RequestBody String id, @Valid @RequestBody Facet facet) {
        return "Adding new facet to vehicle....";
    }

    @PostMapping("/vehiclesss")
    String newVehicle() {
        Engine engine = new Engine();
        engine.setFuel("asd");
        engine.setCylinder_capacity(666);
        engine.setPrice_from_base(0);
        engine.setHorsepower(420);
        vehicleService.saveOrUpdate(null);
        return engine.getId();

    }
}
