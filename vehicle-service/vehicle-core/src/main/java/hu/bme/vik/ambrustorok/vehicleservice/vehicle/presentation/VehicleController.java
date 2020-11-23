package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionResponseNoPrice;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.service.VehicleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController implements VehicleServiceClient {

    private final VehicleServiceImpl service;
    private final VehicleMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> findOne(@PathVariable UUID id) {
        Optional<VehicleEntity> entity = service.findOne(id);
        return entity.isPresent() ?  ResponseEntity.ok(mapper.EntityToDTO(entity.get())) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Collection<VehicleResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @GetMapping("manufacturers")
    public ResponseEntity<Collection<String>> findManufacturers() {
        return ResponseEntity.ok(service.findManufacturers());
    }

    @GetMapping("manufacturers/{manufacturer}")
    public ResponseEntity<Collection<String>> findModelsByManufacturer(@PathVariable String manufacturer) {
        return ResponseEntity.ok(service.findModelsByManufacturer(manufacturer));
    }

    @GetMapping("manufacturers/{manufacturer}/options")
    public ResponseEntity<Collection<OptionResponseNoPrice>> findOptionsByManufacturer(@PathVariable String manufacturer) {
        return ResponseEntity.ok(service.findOptionsByManufacturer(manufacturer));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> create(@RequestBody VehicleRequest dto, UriComponentsBuilder b) {
        try {
            VehicleEntity result = service.create(dto);

            UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> modify(@PathVariable UUID id, @RequestBody VehicleResponse dto) {

        try {
            VehicleEntity result = service.update(id, dto);

            return ResponseEntity.ok(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {

        boolean isRemoved = service.delete(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }
}