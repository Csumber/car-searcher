package hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        name = "vehicle-service-vehicle-v1",
        url = "localhost:8085/vehicle",
        decode404 = true)
public interface VehicleServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<VehicleResponse> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<Collection<VehicleResponse>> findAll();

    @GetMapping("manufacturers")
    ResponseEntity<Collection<String>> findManufacturers();

}

