package hu.bme.vik.ambrustorok.vehicleservice.vehicle.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.VehicleServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController implements VehicleServiceIF {

    private VehicleService service;
    private VehicleMapper mapper;

    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::EntityToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findOne(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.EntityToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> create(@RequestBody VehicleRegisterDTO dto, UriComponentsBuilder b) {
        try {
            VehicleEntity result = service.create(dto);

            UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> modify(@PathVariable UUID id, @RequestBody VehicleDTO dto) {

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