package hu.bme.vik.ambrustorok.vehicleservice.option;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "vehicle-service-option-v1",
        url = "localhost:8088/option")
public interface OptionServiceIF {
    @GetMapping("{id}")
    ResponseEntity<OptionDTO> findOne(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<Page<OptionDTO>> findAll(Pageable pageable);

}
