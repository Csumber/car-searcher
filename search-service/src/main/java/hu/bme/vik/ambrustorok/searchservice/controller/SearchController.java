package hu.bme.vik.ambrustorok.searchservice.controller;

<<<<<<< HEAD
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.option.OptionDTO;
import hu.bme.vik.ambrustorok.vehicleservice.option.OptionServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleServiceIF;
=======
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceIF;
>>>>>>> 3dad08e25e2fbdf2571680ee3d65a085abf33ca1
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

<<<<<<< HEAD
    private VehicleServiceIF vehicleServiceIF;
    private EngineServiceIF engineServiceIF;
    private OptionServiceIF optionServiceIF;
=======
    private final VehicleServiceIF vehicleServiceIF;
    private final EngineServiceIF engineServiceIF;
    private final OptionServiceIF optionServiceIF;
>>>>>>> 3dad08e25e2fbdf2571680ee3d65a085abf33ca1

    @GetMapping
    public ResponseEntity<String> Hello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<VehicleResponse> finOneVehicle(@PathVariable UUID id) {
        return vehicleServiceIF.findOne(id);
    }

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleResponse>> findAllVehicles() {
        return vehicleServiceIF.findAll();
    }

    @GetMapping("engine/{id}")
    public ResponseEntity<EngineResponse> finOneEngine(@PathVariable UUID id) {
        return engineServiceIF.findOne(id);
    }

    @GetMapping("/engine")
    public ResponseEntity<List<EngineResponse>> findAllEngines() {
        return engineServiceIF.findAll();
    }

    @GetMapping("option/{id}")
    public ResponseEntity<OptionResponse> finOneOption(@PathVariable UUID id) {
        return optionServiceIF.findOne(id);
    }

    @GetMapping("/option")
    public ResponseEntity<List<OptionResponse>> findAllOptions() {
        return optionServiceIF.findAll();
    }

    @GetMapping("engine/{id}")
    public ResponseEntity<OptionDTO> finOneOption(@PathVariable UUID id) {
        return optionServiceIF.findOne(id);
    }

    @GetMapping("/engine")
    public ResponseEntity<Page<OptionDTO>> findAllOptions(Pageable pageable) {
        return optionServiceIF.findAll(pageable);
    }

}