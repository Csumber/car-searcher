package hu.bme.vik.ambrustorok.searchservice.controller;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.option.OptionDTO;
import hu.bme.vik.ambrustorok.vehicleservice.option.OptionServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleServiceIF;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    private final VehicleServiceIF vehicleServiceIF;
    private final EngineServiceIF engineServiceIF;
    private final OptionServiceIF optionServiceIF;

    @GetMapping
    public ResponseEntity<String> Hello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<VehicleDTO> finOneVehicle(@PathVariable UUID id) {
        return vehicleServiceIF.findOne(id);
    }

    @GetMapping("/vehicle")
    public ResponseEntity<Page<VehicleDTO>> findAllVehicles(Pageable pageable) {
        return vehicleServiceIF.findAll(pageable);
    }

    @GetMapping("engine/{id}")
    public ResponseEntity<EngineDTO> finOneEngine(@PathVariable UUID id) {
        return engineServiceIF.findOne(id);
    }

    @GetMapping("/engine")
    public ResponseEntity<Page<EngineDTO>> findAllEngines(Pageable pageable) {
        return engineServiceIF.findAll(pageable);
    }
    @GetMapping("option/{id}")
    public ResponseEntity<OptionDTO> finOneOption(@PathVariable UUID id) {
        return optionServiceIF.findOne(id);
    }

    @GetMapping("/option")
    public ResponseEntity<Page<OptionDTO>> findAllOptions(Pageable pageable) {
        return optionServiceIF.findAll(pageable);
    }

}