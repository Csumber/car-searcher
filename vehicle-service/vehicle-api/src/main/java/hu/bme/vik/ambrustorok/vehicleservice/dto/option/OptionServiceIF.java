package hu.bme.vik.ambrustorok.vehicleservice.dto.option;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "vehicle-service-option-v1",
        url = "localhost:8088/option")
public interface OptionServiceIF {
    @GetMapping("{id}")
    ResponseEntity<OptionResponse> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<OptionResponse>> findAll();

}
