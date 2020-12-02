package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
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

    @GetMapping
    public ResponseEntity<Collection<VehicleResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> create(@RequestBody VehicleRequest dto, UriComponentsBuilder b) {
        try {
            VehicleEntity result = service.create(dto);

            UriComponents uriComponents = b.path("/vehicle/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> findOne(@PathVariable UUID id) {
        Optional<VehicleEntity> entity = service.findOne(id);
        return entity.map(vehicleEntity -> ResponseEntity.ok(mapper.EntityToDTO(vehicleEntity))).orElseGet(() -> ResponseEntity.notFound().build());
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

    @GetMapping("manufacturer")
    public ResponseEntity<Collection<String>> findManufacturers() {
        return ResponseEntity.ok(service.findManufacturers());
    }

    @GetMapping("manufacturer/{manufacturer}")
    public ResponseEntity<Collection<String>> findModelsByManufacturer(@PathVariable String manufacturer) {
        return ResponseEntity.ok(service.findModelsByManufacturer(manufacturer));
    }

    @GetMapping("option/{id}")
    public ResponseEntity<Collection<VehicleResponse>> findAllByOption(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findAllByOption(id).stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @GetMapping("engine/{id}")
    public ResponseEntity<Collection<VehicleResponse>> findAllbyEngine(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findAllbyEngine(id).stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @PutMapping("option/{id}")
    public ResponseEntity<VehicleResponse> addOptiontoVehicle(@PathVariable UUID id, @RequestBody OptionRequest optionDTO) {
        Optional<VehicleEntity> vehicle = service.findOne(id);
        if (vehicle.isEmpty())
            return ResponseEntity.notFound().build();
        Optional<OptionEntity> option = service.checkOptionExistence(optionDTO);
        if (option.isEmpty())
            service.addNewOption(vehicle.get(), optionDTO, optionDTO.getPrice());
        else
            service.addOption(vehicle.get(), option.get(), optionDTO.getPrice());
        return vehicle.map(vehicleEntity -> ResponseEntity.ok(mapper.EntityToDTO(vehicleEntity))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("engine/{id}")
    public ResponseEntity<VehicleResponse> addEnginetoVehicle(@PathVariable UUID id, @RequestBody EngineRequest engineDTO) {
        Optional<VehicleEntity> vehicle = service.findOne(id);
        if (vehicle.isEmpty())
            return ResponseEntity.notFound().build();
        Optional<EngineEntity> engine = service.checkEngineExistence(engineDTO);
        if (engine.isEmpty())
            service.addNewEngine(vehicle.get(), engineDTO, engineDTO.getPrice());
        else
            service.addEngine(vehicle.get(), engine.get(), engineDTO.getPrice());
        return vehicle.map(vehicleEntity -> ResponseEntity.ok(mapper.EntityToDTO(vehicleEntity))).orElseGet(() -> ResponseEntity.notFound().build());
    }

}

