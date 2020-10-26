package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.model.Style;
import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.OptionResponse;
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
        return vehicleService.getManufacturers();
    }

    @GetMapping("/manufacturers/{manufacturer}")
    @ResponseBody
    public List<String> getAllModelsOfManufacturer(@RequestParam String manufacturer) {
        return vehicleService.getModelsOfManufacturer(manufacturer);
    }

    @GetMapping("/manufacturers/{manufacturer}/{model}")
    @ResponseBody
    public List<OptionResponse> getAllModelsOfManufacturer(@RequestParam String manufacturer, @RequestParam String model) {
        return vehicleService.getOptions();
    }
    @GetMapping("/options")
    @ResponseBody
    public List<OptionResponse> getAllModelsOfManufacturer() {
        return vehicleService.getOptions();
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
        return vehicleService.getVehicles();
    }

    @PostMapping("/vehicles")
    public String addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setManufacturer("Audi");
        vehicle1.setModel("A4");
        vehicle1.setStyle(Style.Sedan);
        vehicle1.setBase_price(50000);
        vehicle1.setNumber_of_doors(4);
        vehicle1.setWarranty(5);
        vehicle1.setWeight(1500);

        Set<Engine> engines = new HashSet<>();
        Engine e1 = new Engine(220, "Diesel", "Automatic", 5, 1945, 5000);
        Engine e2 = new Engine(372, "Gasoline", "Automatic", 9, 2945, 15000);
        engines.add(e1);
        engines.add(e2);
        engineRepository.save(e1);
        engineRepository.save(e2);

        vehicle1.setEngines(engines);

        Set<Option> options = new HashSet<>();
        options.add(new Option("AC", "No AC", 0));
        options.add(new Option("AC", "Manual", 500));
        options.add(new Option("AC", "Automatic", 1000));
        vehicle1.setOptions(options);

        vehicleRepository.save(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setManufacturer("BMW");
        vehicle2.setModel("Series 5");
        vehicle2.setStyle(Style.Sedan);
        vehicle2.setBase_price(55000);
        vehicle2.setNumber_of_doors(4);
        vehicle2.setWarranty(3);
        vehicle2.setWeight(1700);

        vehicle2.setEngines(engines);
        vehicle2.setOptions(options);

        vehicleRepository.save(vehicle2);

        Vehicle vehicle3 = new Vehicle();
       vehicle3.setManufacturer("Audi");
       vehicle3.setModel("A5");
       vehicle3.setStyle(Style.Coupe);
       vehicle3.setBase_price(65000);
       vehicle3.setNumber_of_doors(4);
       vehicle3.setWarranty(5);
       vehicle3.setWeight(1300);

        engines.add(e1);
        engines.add(e2);

        vehicle3.setEngines(engines);

        vehicle3.setOptions(options);

        vehicleRepository.save(vehicle3);

        return "Adding new vehicle....";
    }

    @PutMapping("/vehicles")
    public String addFacetToExistingVehicles(@Valid @RequestBody String id, @Valid @RequestBody Option facet) {
        return "Adding new facet to vehicle....";
    }

    @GetMapping("/engines")
    public List<EngineResponse> getAllEngines() {
        return vehicleService.getEngines();
    }

    @DeleteMapping("/flush")
    String deleteAll() {
        vehicleRepository.deleteAll();
        engineRepository.deleteAll();
        return "Everything is deleted, my Master.";
    }
}
