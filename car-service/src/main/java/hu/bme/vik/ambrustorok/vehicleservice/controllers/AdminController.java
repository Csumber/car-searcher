package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;
import hu.bme.vik.ambrustorok.vehicleservice.repository.EngineRepository;
import hu.bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import hu.bme.vik.ambrustorok.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    EngineRepository engineRepository;

    @Autowired
    VehicleRepository vehicleRepository;

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
    public List<Option> getAllModelsOfManufacturer(@RequestParam String manufacturer, @RequestParam String model) {
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

    /*
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.engines = engines;
        this.options = options;
        this.base_price = base_price;
        this.number_of_doors = number_of_doors;
        this.warranty = warranty;
        * */
    @PostMapping("/vehicles")
    public String addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setManufacturer("Audi");
        vehicle.setModel("A4");
        vehicle.setType("sedan");
        vehicle.setBase_price(50000);
        vehicle.setNumber_of_doors(4);
        vehicle.setWarranty(5);
        vehicle.setWeight(1500);

        Set<Engine> engines = new HashSet<>();
        Engine e1 = new Engine("", 220, "Diesel", "Automatic", 5, 1945, 5000);
        Engine e2 = new Engine("", 372, "Gasoline", "Automatic", 9, 2945, 15000);
        engines.add(e1);
        engines.add(e2);
        engineRepository.save(e1);
        engineRepository.save(e2);

        vehicle.setEngines(engines);

        Set<Option> options = new HashSet<>();
        options.add(new Option("AC", "No AC", 0));
        options.add(new Option("AC", "Manual", 500));
        options.add(new Option("AC", "Automatic", 1000));
        vehicle.setOptions(options);

        vehicleRepository.save(vehicle);

        return "Adding new vehicle....";
    }

    @PutMapping("/vehicles")
    public String addFacetToExistingVehicles(@Valid @RequestBody String id, @Valid @RequestBody Option facet) {
        return "Adding new facet to vehicle....";
    }

    @DeleteMapping("/flush")
    String deleteAll() {
        vehicleRepository.deleteAll();
        engineRepository.deleteAll();
        return "Everything is deleted, my Master.";
    }
}
