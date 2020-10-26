package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;
import hu.bme.vik.ambrustorok.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class UserController {

    @Autowired
    VehicleService vehicleService;

    // <========================================================

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<String>> getManufacturers() {
        return ResponseEntity.ok(vehicleService.getManufacturers());
    }

    @GetMapping("/{manufacturer}")
    @ResponseBody
    public ResponseEntity<List<String>> getModelsOfManufacturer(@RequestParam String manufacturer) {
        return ResponseEntity.ok(vehicleService.getModelsOfManufacturer(manufacturer));
    }

    @GetMapping("/{manufacturer}/{model}")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getCarsOfModel(@RequestParam String manufacturer, @RequestParam String model) {
        return ResponseEntity.ok(vehicleService.getCarsOfModel(manufacturer, model));
    }

    // <========================================================

    @GetMapping("/options")
    @ResponseBody
    public ResponseEntity<List<OptionResponse>> getOptions() {
        return ResponseEntity.ok(vehicleService.getOptions());
    }

    @GetMapping("/options/{manufacturer}")
    @ResponseBody
    public ResponseEntity<List<OptionResponse>> getManufacturerOptions(@RequestParam String manufacturer) {
        return ResponseEntity.ok(vehicleService.getManufacturerOptions(manufacturer));
    }

    @GetMapping("/options/{manufacturer}/{model}")
    @ResponseBody
    public ResponseEntity<List<OptionResponse>> getModelOptions(@RequestParam String manufacturer, @RequestParam String model) {
        return ResponseEntity.ok(vehicleService.getModelOptions(manufacturer, model));
    }

    // <========================================================

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @GetMapping("/vehicles/{manufacturer}")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getManufacturerVehicles(@RequestParam String manufacturer) {
        return ResponseEntity.ok(vehicleService.getManufacturerVehicles(manufacturer));
    }

    @GetMapping("/vehicles/{manufacturer}/{model}")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getModelVehicles(@RequestParam String manufacturer, @RequestParam String model) {
        return ResponseEntity.ok(vehicleService.getModelVehicles(manufacturer, model));
    }

    // <========================================================

    @GetMapping("/engines")
    public ResponseEntity<List<EngineResponse>> getEngines() {
        return ResponseEntity.ok(vehicleService.getEngines());
    }

    @GetMapping("/engines/{manufacturer}")
    @ResponseBody
    public ResponseEntity<List<EngineResponse>> getManufacturerEngines(@RequestParam String manufacturer) {
        return ResponseEntity.ok(vehicleService.getManufacturerEngines(manufacturer));
    }

    @GetMapping("/engines/{manufacturer}/{model}")
    @ResponseBody
    public ResponseEntity<List<EngineResponse>> getModelEngines(@RequestParam String manufacturer, @RequestParam String model) {
        return ResponseEntity.ok(vehicleService.getModelEngines(manufacturer, model));
    }
    // <========================================================

    @PostMapping("/search")
    @ResponseBody
    public List<SearchResult> search(@RequestBody SearchRequest searchRequest) {
        //TODO do not save in searchDB
        return vehicleService.search(searchRequest);
    }


}
