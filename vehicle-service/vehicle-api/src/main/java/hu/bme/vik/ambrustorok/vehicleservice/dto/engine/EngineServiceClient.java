package hu.bme.vik.ambrustorok.vehicleservice.dto.engine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        name = "vehicle-service-engine-v1",
        url = "localhost:8088/engine",decode404 = true)
public interface EngineServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<EngineResponse> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<Collection<EngineResponse>> findAll();

}
