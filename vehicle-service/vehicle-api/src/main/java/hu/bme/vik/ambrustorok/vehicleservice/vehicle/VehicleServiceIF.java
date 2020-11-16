package hu.bme.vik.ambrustorok.vehicleservice.vehicle;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "vehicle-service-vehicle-v1",
        url = "localhost:8088/vehicle")
public interface VehicleServiceIF {
    @GetMapping("{id}")
    ResponseEntity<VehicleDTO> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<Page<VehicleDTO>> findAll(Pageable pageable);

}
