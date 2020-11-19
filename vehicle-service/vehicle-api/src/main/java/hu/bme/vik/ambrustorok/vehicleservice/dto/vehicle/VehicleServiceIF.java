package hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "vehicle-service-vehicle-v1",
        url = "localhost:8088/vehicle")
public interface VehicleServiceIF {
    @GetMapping("{id}")
    ResponseEntity<VehicleResponse> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<VehicleResponse>> findAll();

    @GetMapping("manufacturers")
    ResponseEntity<List<String>> findManufacturers();

}
