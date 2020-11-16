package hu.bme.vik.ambrustorok.vehicleservice;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "vehicle-service-v1",
        url = "${services.vehicle-service-url:localhost:8088}/vehicle")
public interface VehicleServiceIF {
    @GetMapping("engine/{id}")
    ResponseEntity<EngineDTO> findOneEngine(@PathVariable UUID id);

    @GetMapping("vehicle/{id}")
    ResponseEntity<EngineDTO> findOneVehicle(@PathVariable UUID id);

    @GetMapping("option/{id}")
    ResponseEntity<EngineDTO> findOneOption(@PathVariable UUID id);

}
