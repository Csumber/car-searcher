package hu.bme.vik.ambrustorok.vehicleservice.engine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "vehicle-service-engine-v1",
        url = "localhost:8088/engine")
public interface EngineServiceIF {
    @GetMapping("{id}")
    ResponseEntity<EngineDTO> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<Page<EngineDTO>> findAll(Pageable pageable);

}
