package hu.bme.vik.ambrustorok.searchservice.controller;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    private final VehicleServiceClient vehicleServiceClient;
    private final EngineServiceClient engineServiceClient;
    private final OptionServiceClient optionServiceClient;

    @GetMapping("vehicle/{id}")
    public ResponseEntity<VehicleResponse> finOneVehicle(@PathVariable UUID id) {
        return vehicleServiceClient.findOne(id);
    }

    @GetMapping("/vehicle")
    public ResponseEntity<Collection<VehicleResponse>> findAllVehicles() {
        return vehicleServiceClient.findAll();
    }

    @GetMapping("engine/{id}")
    public ResponseEntity<EngineResponse> finOneEngine(@PathVariable UUID id) {
        return engineServiceClient.findOne(id);
    }

    @GetMapping("/engine")
    public ResponseEntity<Collection<EngineResponse>> findAllEngines() {
        return engineServiceClient.findAll();
    }

    @GetMapping("option/{id}")
    public ResponseEntity<OptionResponse> finOneOption(@PathVariable UUID id) {
        return optionServiceClient.findOne(id);
    }

    @GetMapping("/option")
    public ResponseEntity<Collection<OptionResponse>> findAllOptions() {
        return optionServiceClient.findAll();
    }

}

